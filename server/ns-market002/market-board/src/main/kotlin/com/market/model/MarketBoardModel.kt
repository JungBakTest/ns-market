package com.market.model

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard

//
data class BoardCreatedRequest(
    val title: String,
    val content: String,
    val category: Long,
    val price: Long,
)

data class BoardCreateResponse(
    val userId: Long,
    val boardId: Long?,
    val title: String,
    val content: String,
    val viewCount: Long,
    val category: Long,
    val price: Long,
    val imgStorages : MutableList<String>,
){
    constructor(marketBoard: MarketBoard, fileKeyList: MutableList<String>) :
            this(marketBoard.userId, marketBoard.boardId, marketBoard.title, marketBoard.content,
                marketBoard.viewCount, marketBoard.category, marketBoard.price, fileKeyList )
}


data class BoardViewResponse(
    val userId: Long,
    val boardId: Long?,
    val title: String,
    val content: String,
    val viewCount: Long,
    val category: Long,
    val price: Long,
    val imgStorages : List<String>,
){
    constructor(marketBoard: MarketBoard, fileUrlList: List<String>) :
            this(marketBoard.userId, marketBoard.boardId, marketBoard.title, marketBoard.content,
                marketBoard.viewCount, marketBoard.category, marketBoard.price, fileUrlList )
}


data class BoardViewPost(
    val userId: Long,
    val boardId: Long?,
    val title: String,
    val viewCount: Long,
    val price: Long,
    val mainImgUrl: String,
){
    constructor(marketBoard: MarketBoard, mainImgUrl: String) :
            this(marketBoard.userId, marketBoard.boardId, marketBoard.title,
                marketBoard.viewCount, marketBoard.price, mainImgUrl)
}