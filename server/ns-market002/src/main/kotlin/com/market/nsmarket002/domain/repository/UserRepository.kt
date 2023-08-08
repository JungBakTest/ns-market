package com.market.nsmarket002.domain.repository

import com.market.nsmarket002.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<User, Long> {

    suspend fun findByEmail(email: String) : User?

    suspend fun findFirstByEmail(email: String) : User?
}