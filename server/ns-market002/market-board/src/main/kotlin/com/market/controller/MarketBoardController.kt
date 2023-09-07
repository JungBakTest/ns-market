package com.market.controller

import com.market.config.AuthUser
import com.market.domain.entity.MarketBoard
import com.market.model.BoardCreateResponse
import com.market.model.BoardCreatedRequest
import com.market.service.MarketBoardImageService
import com.market.service.MarketBoardService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/marketboard")
@Tag(name = "Market Board Service API", description = "Market Board Service API입니다.")
class MarketBoardController (
    private val marketBoardService: MarketBoardService,
    private val marketBoardImageService: MarketBoardImageService,
){
    private val logger = KotlinLogging.logger {}
    @PostMapping("/create")
    @Operation(summary = "market Board Create 하는 기능입니다.",
        description = "RequestParam로  files, title, content, category, price를 받습니다.")
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
    @Operation(summary = "market Board Edit 하는 기능입니다.",
        description = "RequestParam로  files, title, content, category, price, boardid를 받습니다.")
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


    @DeleteMapping("/delete")
    @Operation(summary = "market Board Edit 하는 기능입니다.",
        description = "RequestParam로  files, title, content, category, price, boardid를 받습니다.")
    fun marketBoardDelte(
        authUser: AuthUser,
        @RequestParam("boardid") boardId: Long,
    ): String{
        return marketBoardService.boardDelete(authUser.userId, boardId)
    }

    @PutMapping("/imgUpload")
    fun test1(authUser: AuthUser): String{
        return "it's ${authUser.email}"
    }

}