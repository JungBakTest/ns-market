package com.market.service

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard
import com.market.domain.repository.ImgStorageRepository
import com.market.domain.repository.MarketBoardRepository
import com.market.model.BoardCreatedRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class MarketBoardService (
    private val marketBoardRepository: MarketBoardRepository,
    private val imgStorageRepository: ImgStorageRepository,
){

    @Transactional
    fun BoardCreated(userId: Long, request: BoardCreatedRequest, uploadedFileNames: List<String>) : String{
//        val marketBoard = MarketBoard(
//            userId =
//        )

        return with(request){
            val marketBoard = MarketBoard(
                userId = userId,
                title = title,
                content = content,
                viewCount = 0,
                category = 0,
                price = price,
            )

            marketBoardRepository.save(marketBoard)

            for(file in uploadedFileNames){
                    val imgStorage = ImgStorage(
                        imgUrl = file,
                        userId = marketBoard.userId,
                        boardId = marketBoard.boardId
                    )
                imgStorageRepository.save(imgStorage)
            }
            "ok"
        }


    }
}