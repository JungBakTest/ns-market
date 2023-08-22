package com.market.domain.repository

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard
import org.springframework.data.jpa.repository.JpaRepository


interface ImgStorageRepository : JpaRepository<ImgStorage, Long> {
}