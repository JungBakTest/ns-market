package com.market.service

import com.market.domain.entity.MarketBoard
import com.market.domain.repository.MarketBoardRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional


@Service
class TestService (
    private val marketBoardRepository: MarketBoardRepository,
){

    @Transactional
    fun test1(): MarketBoard{
        val optionalMarketBoard: Optional<MarketBoard> =  marketBoardRepository.findById(2)
        if(optionalMarketBoard.isPresent){
            val marketBoard: MarketBoard = optionalMarketBoard.get()
            return marketBoard
        }
        else {
            return MarketBoard()
        }
    }
}