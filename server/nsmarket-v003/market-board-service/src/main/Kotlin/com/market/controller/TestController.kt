package com.market.controller

import com.market.domain.entity.MarketBoard
import com.market.domain.entity.User
import com.market.domain.repository.MarketBoardRepository
import com.market.domain.repository.UserRepository
import com.market.service.TestService
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/marketboard")
class TestController (
//    @Autowired private val marketBoardRepository: MarketBoardRepository,
    private val testService: TestService,
){
//    @Autowired
    lateinit var marketBoardRepository: MarketBoardRepository

    @GetMapping("/test")
    fun test1(): MarketBoard{
        return testService.test1()
    }
}