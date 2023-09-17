package com.market.board.controller

import com.market.board.domain.entity.Category
import com.market.board.domain.repository.CategoryRepository
import com.market.user.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/test")
class testController (
    private val userRepository: UserRepository,
){


    @Autowired
    private lateinit var userRepository: UserRepository
    @GetMapping
    fun test1() : Category {

    }

}