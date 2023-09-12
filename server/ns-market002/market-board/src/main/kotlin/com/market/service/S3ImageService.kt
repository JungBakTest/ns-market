package com.market.service

import com.amazonaws.services.s3.AmazonS3
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*


@Service
class S3ImageService @Autowired constructor(
    private val amazonS3: AmazonS3,
    @Value("\${spring.aws.s3.bucket-name}") private val bucketName: String,
    @Value("\${spring.aws.s3.folder-name}") private val folderName: String,
) {

    fun uploadImage(file: MultipartFile): String {
        val key = "${folderName}/${UUID.randomUUID()}${generateKey(file.originalFilename)}"
        try {
            amazonS3.putObject(bucketName, key, file.inputStream, null)
            return key
        } catch (e: IOException) {
            throw RuntimeException("Failed to upload image to S3", e)
        }
    }

    fun generateKey(originalFilename: String?): String {
        return originalFilename ?: "image-${System.currentTimeMillis()}"
    }

    fun getImageUrl(imageKey: String): String {
        return amazonS3.getUrl(bucketName, imageKey).toString()
    }
}