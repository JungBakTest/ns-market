package com.market.domain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ConfigurationPropertiesScan
class MarketCoreServiceApplication

fun main(args: Array<String>) {
    runApplication<MarketCoreServiceApplication>(*args)
}
