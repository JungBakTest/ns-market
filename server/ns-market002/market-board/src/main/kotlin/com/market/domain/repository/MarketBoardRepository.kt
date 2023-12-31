package com.market.domain.repository

import com.market.domain.entity.MarketBoard
import org.springframework.data.jpa.repository.JpaRepository

interface MarketBoardRepository : JpaRepository<MarketBoard, Long> {
}