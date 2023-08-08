package com.market.nsmarket002.service

import com.auth0.jwt.interfaces.DecodedJWT
import com.market.nsmarket002.config.JWTProperties
import com.market.nsmarket002.domain.entity.User
import com.market.nsmarket002.domain.repository.UserRepository
import com.market.nsmarket002.exception.InvalidJwtTokenException
import com.market.nsmarket002.exception.PassWordNotMatchedException
import com.market.nsmarket002.exception.UserExistsException
import com.market.nsmarket002.exception.UserNotFoundException
import com.market.nsmarket002.model.SignInRequest
import com.market.nsmarket002.model.SignInResponse
import com.market.nsmarket002.model.SignUpRequest
import com.market.nsmarket002.utils.BCryptUtils
import com.market.nsmarket002.utils.JWTClaim
import com.market.nsmarket002.utils.JWTUtils
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService (
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
){

    companion object{
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

    suspend fun signUp(signUpRequest: SignUpRequest){
        with(signUpRequest){
            userRepository.findByEmail(email)?.let{
                throw UserExistsException()
            }

            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username,
            )

            userRepository.save(user)
        }
    }

    suspend fun signIn(signInRequest: SignInRequest) : SignInResponse {
        return with(userRepository.findByEmail(signInRequest.email) ?: throw UserNotFoundException()){
            val verified = BCryptUtils.verify(signInRequest.password, password)
            if(!verified){
                throw PassWordNotMatchedException()
            }
            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username
            )

            val token = JWTUtils.createToken(jwtClaim, jwtProperties)

            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)
            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }

    suspend fun logout(token: String){
        cacheManager.awaitEvict(token)
    }

    suspend fun getByToken(token: String): User {
        val cacheUser = cacheManager.awaitGetOrPut(key = token, ttl= CACHE_TTL){
            // 캐시가 유효하지 않는 경우 동작
            val decodedJWT: DecodedJWT = JWTUtils.decode(token, jwtProperties.secret, jwtProperties.issuer)

            val userId: Long = decodedJWT.claims["userId"]?.asLong() ?: throw InvalidJwtTokenException()
            get(userId)
        }
        return cacheUser

    }

    suspend fun get(userId: Long) : User{
        return userRepository.findById(userId) ?: throw UserNotFoundException()
    }

    suspend fun edit(token: String, username: String, profileUrl: String?): User {
        val user = getByToken(token)
        val newUser = user.copy(username = username, profileUrl = profileUrl ?: user.profileUrl )

        return userRepository.save(newUser).also {
            cacheManager.awaitPut(key = token, value = it, ttl = CACHE_TTL)
        }
    }
}