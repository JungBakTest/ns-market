package com.market.domain.repository

import com.market.domain.entity.MarketBoard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MarketBoardRepository : JpaRepository<MarketBoard, Long> {
}