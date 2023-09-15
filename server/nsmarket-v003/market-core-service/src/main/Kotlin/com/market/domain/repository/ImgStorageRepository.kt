package com.market.domain.repository

import com.market.domain.entity.ImgStorage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ImgStorageRepository : JpaRepository<ImgStorage, Long> {

    fun findAllByBoardId(boardId: Long?): List<ImgStorage>

    fun findFirstByBoardId(boardId: Long?): Optional<ImgStorage>
}