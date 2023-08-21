package com.market.controller

import com.market.config.AuthUser
import com.market.model.BoardCreatedRequest
import com.market.service.MarketBoardImageService
import com.market.service.MarketBoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/marketboard")
class MarketBoardController (
    private val marketBoardService: MarketBoardService,
    private val marketBoardImageService: MarketBoardImageService,
){
    @PostMapping("/create")
    fun marketBoardCreate(
        authUser: AuthUser,
        @RequestBody request: BoardCreatedRequest,
        @RequestParam("files") files: List<MultipartFile>,
    ): ResponseEntity<String> {
        val uploadedFileName = marketBoardImageService.uploadImage(files)

        val responseMessage = "it's ok"
        return ResponseEntity.ok(responseMessage)

    }
    @GetMapping("/test1")
    fun test1(
        authUser: AuthUser
    ) : String {
        return "${authUser.email}"
    }

}