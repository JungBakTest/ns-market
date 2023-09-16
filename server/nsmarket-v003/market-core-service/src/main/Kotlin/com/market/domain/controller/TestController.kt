package com.market.domain.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test1")
class TestController {
    @GetMapping("/test")
    fun test(): String{
        return "1235"
    }
}