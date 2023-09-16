package com.market.board.service

import com.market.domain.entity.MarketBoard
import com.market.domain.repository.MarketBoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class TestService (
    private val boardRepository: MarketBoardRepository,
){
    @Autowired
    fun test(): MarketBoard = boardRepository.findByIdOrNull(2) ?: throw IllegalArgumentException("board 데이터가 없음")
}