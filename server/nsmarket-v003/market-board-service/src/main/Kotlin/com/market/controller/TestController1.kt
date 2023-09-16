package com.market.controller

import com.market.domain.entity.MarketBoard
import com.market.service.TestService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/test12")
class TestController1 (
    private val testService: TestService,
){
    @GetMapping("/test")
    fun test(): MarketBoard{
        return testService.test()
    }
}