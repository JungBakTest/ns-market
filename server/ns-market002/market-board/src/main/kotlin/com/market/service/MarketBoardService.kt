package com.market.service

import com.market.model.BoardCreatedRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class MarketBoardService {

    @Transactional
    fun BoardCreated(userId: Long, request: BoardCreatedRequest){

    }
}