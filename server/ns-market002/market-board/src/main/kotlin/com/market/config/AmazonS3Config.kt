package com.market.config

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AmazonS3Config(
    @Value("\${spring.aws.credentials.access-key}")
    private val accessKey: String,

    @Value("\${spring.aws.credentials.secret-key}")
    private val secretKey: String,

    @Value("\${spring.aws.s3.region}")
    private val region: String
) {

    @Bean
    fun amazonS3Client(): AmazonS3 {
        val credentialsProvider: AWSCredentialsProvider = AWSStaticCredentialsProvider(BasicAWSCredentials(accessKey, secretKey))
        return AmazonS3ClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withRegion(region)
            .build()
    }
}