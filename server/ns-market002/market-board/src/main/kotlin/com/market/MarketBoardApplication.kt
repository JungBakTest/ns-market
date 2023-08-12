package com.market

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class MarketBoardApplication

fun main(args: Array<String>){
    runApplication<MarketBoardApplication>(*args)
}