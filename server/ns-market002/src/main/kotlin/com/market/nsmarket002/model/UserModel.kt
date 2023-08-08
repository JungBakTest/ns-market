package com.market.nsmarket002.model

import com.market.nsmarket002.domain.entity.User
import java.time.LocalDateTime

data class UserEditRequest(
    val username: String,
)

data class MeResponse(
    val id : Long,
    val profileUrl : String?,
    val username : String,
    val email : String,
    val createdAt : LocalDateTime?,
    val updatedAt : LocalDateTime?,
){

    companion object{
        operator fun invoke(user: User) = with(user){
            MeResponse(
                id = id!!,
                profileUrl = if (profileUrl.isNullOrEmpty()) null else "http://localhost:8080/images/$profileUrl",
                username = username,
                email = email,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )
        }
    }
}