package com.market.service

import com.market.domain.entity.MarketBoard
import com.market.domain.repository.MarketBoardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping


@Service
class TestService (
    private val boardRepository: MarketBoardRepository,
){
    fun test(): MarketBoard = boardRepository.findByIdOrNull(2) ?: throw IllegalArgumentException("board 데이터가 없음")
}