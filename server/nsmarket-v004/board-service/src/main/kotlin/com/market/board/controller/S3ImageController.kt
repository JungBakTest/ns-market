package com.market.board.controller

import com.market.board.service.S3ImageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/images")
class S3ImageController(private val s3ImageService: S3ImageService) {

    @PostMapping("/upload")
    fun uploadImage(@RequestParam file: MultipartFile): ResponseEntity<String> {
        val imageKey = s3ImageService.uploadImage(file)
        return ResponseEntity.ok("Image uploaded successfully. Key: $imageKey")
    }

    @GetMapping("/{imageKey}")
    fun getImageUrl(@PathVariable imageKey: String): ResponseEntity<String> {
        val imageUrl = s3ImageService.getImageUrl(imageKey)
        return ResponseEntity.ok(imageUrl)
    }
}