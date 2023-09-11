package com.market.domain.repository

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface ImgStorageRepository : JpaRepository<ImgStorage, Long> {

    fun findAllByBoardId(boardId: Long?): List<ImgStorage>

    fun findFirstByBoardId(boardId: Long?): Optional<ImgStorage>
}