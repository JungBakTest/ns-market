package com.market.user.domain.repository


import com.market.user.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CoroutineCrudRepository<User, Long> {

    suspend fun findByEmail(email: String) : User?

    suspend fun findFirstByEmail(email: String) : User?
}