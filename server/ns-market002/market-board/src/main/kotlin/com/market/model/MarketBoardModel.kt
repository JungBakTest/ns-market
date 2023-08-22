package com.market.model
//
data class BoardCreatedRequest(
    val title: String,
    val content: String,
    val category: Long,
    val price: Long,
)

data class BoardCreateResponse(
    val userId: Long,
)