//package com.market.controller
//import org.springframework.http.HttpStatus
//import org.springframework.http.MediaType
//import org.springframework.http.ResponseEntity
//import org.springframework.stereotype.Controller
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.*
//import org.springframework.web.multipart.MultipartFile
//import java.awt.PageAttributes
//import java.io.File
//import java.io.FileOutputStream
//import java.io.IOException
//import java.nio.file.Files
//import java.nio.file.Path
//import java.nio.file.Paths
//import java.util.*
//
//@RestController
//@RequestMapping("/api/MarketBoardImages")
//class MarketBoardImageController {
//    private val uploadDir = "./uploads/"
//    init {
//        File(uploadDir).mkdirs()
//    }
//
//    @PostMapping("/upload")
//    fun uploadImage(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
//        if (file.isEmpty) {
//            return ResponseEntity("File is empty", HttpStatus.BAD_REQUEST)
//        }
//        val uniqueFileName = "${UUID.randomUUID()}_${file.originalFilename}"
//        val filePath = File(uploadDir, uniqueFileName)
//        try {
//            FileOutputStream(filePath).use { fos ->
//                fos.write(file.bytes)
//            }
//            return ResponseEntity("File uploaded successfully: $uniqueFileName", HttpStatus.OK)
//        } catch (e: IOException) {
//            return ResponseEntity("Error uploading file: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
//        }
//    }
//    @GetMapping("/{filename}")
//    fun getImage(@PathVariable filename: String): ResponseEntity<ByteArray> {
//        val imageFile = File(uploadDir, filename)
//        if (!imageFile.exists()) {
//            return ResponseEntity(HttpStatus.NOT_FOUND)
//        }
//
//        val bytes = imageFile.readBytes()
//        return ResponseEntity.ok()
//            .contentType(MediaType.IMAGE_JPEG)
//            .body(bytes)
//    }
//    @GetMapping("/test1")
//    suspend fun test1() : String{
//        return "it's ok"
//    }
//}