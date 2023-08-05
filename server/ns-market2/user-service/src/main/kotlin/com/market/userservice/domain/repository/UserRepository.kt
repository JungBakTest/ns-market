package com.market.userservice.domain.repository

import com.market.userservice.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<User, Long> {

    suspend fun findByEmail(email: String) : User?

    suspend fun findFirstByEmail(email: String) : User?
}