package com.market.board.controller


import com.market.board.config.AuthUser
import com.market.board.model.BoardCreateResponse
import com.market.board.model.BoardCreatedRequest
import com.market.board.model.BoardViewPost
import com.market.board.model.BoardViewResponse
import com.market.board.service.MarketBoardImageService
import com.market.board.service.MarketBoardService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging
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

    @GetMapping("/view/{boardId}")
    @Operation(summary = "market Board view 하는 기능입니다.")
    fun view(
        @PathVariable boardId: Long,
    ): BoardViewResponse {
        return marketBoardService.boardView(boardId)
    }

    @GetMapping("/view/list")
    @Operation(summary = "market Board view List 하여 보내주는 기능입니다.",
        description = "RequestParam로  files, title, content, category, price, boardid를 받습니다.")
    fun viewList(): List<BoardViewPost> {
        return marketBoardService.getBoardViewList()
    }

    @GetMapping("/view/profile/{userId}")
    @Operation(summary = "market Board view List 하여 보내주는 기능입니다.",
        description = "RequestParam로  files, title, content, category, price, boardid를 받습니다.")
    fun viewList(
        @PathVariable userId: Long,

    ){


    }


}