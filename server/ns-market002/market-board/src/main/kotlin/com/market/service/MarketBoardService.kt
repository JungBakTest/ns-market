package com.market.service

import com.market.domain.entity.ImgStorage
import com.market.domain.entity.MarketBoard
import com.market.domain.repository.ImgStorageRepository
import com.market.domain.repository.MarketBoardRepository
import com.market.exception.MarketBoardIdNotFoundException
import com.market.exception.MismatchedMarketBoardUserException
import com.market.model.BoardCreateResponse
import com.market.model.BoardCreatedRequest
import com.market.model.BoardViewResponse
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

            // 이미지 이전꺼 삭제
            val imgsToDelete = imgStorageRepository.findAllByBoardId(marketBoard.boardId)

            for (img in imgsToDelete){
                imgStorageRepository.delete(img)
            }
            // 새로 생긴 이미지 생성
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

    @Transactional
    fun boardDelete(userId: Long, boardId: Long): String{
        val marketBoard: MarketBoard = marketBoardRepository.findByIdOrNull(boardId) ?: throw MarketBoardIdNotFoundException()
        val imgsToDelete = imgStorageRepository.findAllByBoardId(marketBoard.boardId)

        for (img in imgsToDelete){
            imgStorageRepository.delete(img)
        }
        marketBoardRepository.delete(marketBoard)

        return "ok."
    }

    @Transactional
    fun boardView(boardId: Long): BoardViewResponse{
        val marketBoard = marketBoardRepository.findByIdOrNull(boardId) ?: throw MarketBoardIdNotFoundException()
        val imgStorageList = imgStorageRepository.findAllByBoardId(boardId)
        val imgUrlList: List<String> = imgStorageList.map { it.imgUrl }
        return BoardViewResponse(marketBoard, imgUrlList)
    }
//    @Transactional
//    fun getBoardList(): List<BoardViewResponse>{
//        val limit = 10
//        val boardList = marketBoardRepository.findAll().take(limit)
//
//        val responseList = mutableListOf<BoardViewResponse>()
//        for(board in boardList){
//            val boardImgList = imgStorageRepository.findAllByBoardId(board.boardId)
//
//            responseList.add(BoardViewResponse(board, boardImgList))
//        }
//
//    }


}