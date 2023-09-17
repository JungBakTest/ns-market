package com.market.board

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

//(scanBasePackages = ["com.market.board"])
@SpringBootApplication
@ConfigurationPropertiesScan
class NsMarketBoardServiceApplication

fun main(args: Array<String>){
    runApplication<NsMarketBoardServiceApplication>(*args)
}