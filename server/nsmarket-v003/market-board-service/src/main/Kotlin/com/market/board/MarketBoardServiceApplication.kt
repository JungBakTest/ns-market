package com.market.board

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ConfigurationPropertiesScan
//@ComponentScan(basePackages = ["com.market.board"])
@EntityScan(basePackages = ["com.market.domain"])
class MarketBoardServiceApplication

fun main(args: Array<String>) {
	runApplication<MarketBoardServiceApplication>(*args)
}
