package com.market.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.awt.Image
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


@Service
class MarketBoardImageService (
    @Value("\${upload.path}") private val uploadPath: String,
){

    fun uploadImage(files: List<MultipartFile>):List<String>{
        val uploadedFileNames = mutableListOf<String>()

        for (file in files) {
            val uploadedFileName = uploadFile(file)
            uploadedFileNames.add(uploadedFileName)
        }

        return uploadedFileNames
    }

    private fun uploadFile(file: MultipartFile): String {
        val uniqueFileName = "${UUID.randomUUID()}_${file.originalFilename}"
        val filePath = File(uploadPath, uniqueFileName)

        try {
            FileOutputStream(filePath).use { fos ->
                fos.write(file.bytes)
            }
            return uniqueFileName
        } catch (e: IOException) {
            throw RuntimeException("Error uploading file: ${e.message}", e)
        }
    }



}
