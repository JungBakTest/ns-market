package com.market.controller

import com.market.config.AuthUser
import com.market.domain.entity.MarketBoard
import com.market.model.BoardCreateResponse
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
//        @RequestBody request: BoardCreatedRequest,
        @RequestParam("files") files: List<MultipartFile>,
        @RequestParam("title") title: String,
        @RequestParam("content") content: String,
        @RequestParam("category") category: Long,
        @RequestParam("price") price: Long,
    ): BoardCreateResponse {
        val boardCreatedRequest = BoardCreatedRequest(
            title = title,
            content = content,
            category = category,
            price = price,
        )
        return marketBoardService.boardCreated(authUser.userId, boardCreatedRequest,files)
    }

    @PostMapping("/edit")
    fun marketBoardEdit(
        authUser: AuthUser,
        @RequestParam("files") files: List<MultipartFile>,
        @RequestParam("title") title: String,
        @RequestParam("content") content: String,
        @RequestParam("category") category: Long,
        @RequestParam("price") price: Long,
        @RequestParam("boardid") boardId: Long,
    ): BoardCreateResponse
    {
        val boardCreatedRequest = BoardCreatedRequest(
            title = title,
            content = content,
            category = category,
            price = price,
        )
        return marketBoardService.boardEdit(authUser.userId, boardId, boardCreatedRequest,files)
    }


    @PutMapping("/imgUpload")
    fun test1(authUser: AuthUser): String{
        return "it's ${authUser.email}"
    }

}