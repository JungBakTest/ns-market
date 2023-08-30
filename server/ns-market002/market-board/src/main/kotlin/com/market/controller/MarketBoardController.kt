package com.market.controller

import com.market.config.AuthUser
import com.market.domain.entity.MarketBoard
import com.market.model.BoardCreatedRequest
import com.market.service.MarketBoardImageService
import com.market.service.MarketBoardService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/marketboard")
class MarketBoardController (
    private val marketBoardService: MarketBoardService,
    private val marketBoardImageService: MarketBoardImageService,
){
    private val logger = KotlinLogging.logger {}
    @PostMapping("/create")
    fun marketBoardCreate(
        authUser: AuthUser,
        @RequestBody request: BoardCreatedRequest,
//        @RequestParam("files") files: List<MultipartFile>,
    ): MarketBoard {
        return marketBoardService.BoardCreated(authUser.userId, request)
    }

    @PostMapping("/imgUpload")
    fun test1(authUser: AuthUser): String{
        return "it's ${authUser.email}"
    }

}