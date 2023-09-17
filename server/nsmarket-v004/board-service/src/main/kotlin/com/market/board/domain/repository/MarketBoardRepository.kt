package com.market.board.domain.repository

import com.market.board.domain.entity.MarketBoard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MarketBoardRepository : JpaRepository<MarketBoard, Long> {
}