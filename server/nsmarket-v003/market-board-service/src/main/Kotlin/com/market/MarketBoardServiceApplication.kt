package com.market

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ConfigurationPropertiesScan
//@ComponentScan("com.market.domain.entity")
//@ComponentScan("com.market.domain.repository")
class MarketBoardServiceApplication

fun main(args: Array<String>) {
	runApplication<MarketBoardServiceApplication>(*args)
}
