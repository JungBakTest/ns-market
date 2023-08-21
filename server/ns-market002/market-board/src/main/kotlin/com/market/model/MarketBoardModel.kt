package com.market.model
//
data class BoardCreatedRequest(
    val userId: Long,
    val title: String,
    val content: String,
    val viewCount: Long,
    val category: Long,
    val price: Long,
)