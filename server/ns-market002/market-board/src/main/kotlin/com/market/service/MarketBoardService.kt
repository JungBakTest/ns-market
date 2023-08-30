package com.market.service

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard
import com.market.domain.repository.ImgStorageRepository
import com.market.domain.repository.MarketBoardRepository
import com.market.model.BoardCreatedRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class MarketBoardService (
    private val marketBoardRepository: MarketBoardRepository,
    private val imgStorageRepository: ImgStorageRepository,
) {

    @Transactional
    fun BoardCreated(userId: Long, request: BoardCreatedRequest): MarketBoard {
        return with(request) {
            val marketBoard = MarketBoard(
                userId = userId,
                title = title,
                content = content,
                viewCount = 0,
                category = 0,
                price = price,
            )

            marketBoardRepository.save(marketBoard)
        }
    }
}