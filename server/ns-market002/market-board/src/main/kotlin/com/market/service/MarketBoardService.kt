package com.market.service

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard
import com.market.domain.repository.ImgStorageRepository
import com.market.domain.repository.MarketBoardRepository
import com.market.exception.MarketBoardIdNotFoundException
import com.market.exception.MismatchedMarketBoardUserException
import com.market.model.BoardCreateResponse
import com.market.model.BoardCreatedRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import javax.transaction.Transactional


@Service
class MarketBoardService (
    private val marketBoardRepository: MarketBoardRepository,
    private val imgStorageRepository: ImgStorageRepository,
    private val s3ImageService: S3ImageService,
) {

    @Transactional
    fun boardCreated(userId: Long, request: BoardCreatedRequest, files: List<MultipartFile>): BoardCreateResponse {
        return with(request) {
            val marketBoard = MarketBoard(
                userId = userId,
                title = title,
                content = content,
                viewCount = 0,
                category = 0,
                price = price,
            )
            val fileKeyList = mutableListOf<String>()

            for (file in files){
                val imgKey = s3ImageService.uploadImage(file)
                val imgStorage = ImgStorage(
                    imgUrl = imgKey,
                    userId = userId,
                    boardId = marketBoard.boardId,
                )
                fileKeyList.add(imgKey)
                imgStorageRepository.save(imgStorage)
            }
            marketBoardRepository.save(marketBoard)

            BoardCreateResponse(marketBoard, fileKeyList)

        }
    }
    @Transactional
    fun boardEdit(userId: Long, boardId: Long, boardCreatedRequest: BoardCreatedRequest, files: List<MultipartFile>): BoardCreateResponse{
        val marketBoard: MarketBoard = marketBoardRepository.findByIdOrNull(boardId) ?: throw MarketBoardIdNotFoundException()
        if(marketBoard.userId == userId) {
            marketBoard.title = boardCreatedRequest.title
            marketBoard.content = boardCreatedRequest.content
            marketBoard.viewCount = 0
            marketBoard.category = 0
            marketBoard.price = boardCreatedRequest.price

            val fileKeyList = mutableListOf<String>()

            for (file in files) {
                val imgKey = s3ImageService.uploadImage(file)
                val imgStorage = ImgStorage(
                    imgUrl = imgKey,
                    userId = userId,
                    boardId = marketBoard.boardId,
                )
                fileKeyList.add(imgKey)
                imgStorageRepository.save(imgStorage)
            }
            marketBoardRepository.save(marketBoard)
            return BoardCreateResponse(marketBoard, fileKeyList)
        }
        else{
            throw MismatchedMarketBoardUserException()
        }
    }
}