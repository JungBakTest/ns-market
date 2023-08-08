package com.market.nsmarket002

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class NsMarket002Application

fun main(args: Array<String>) {
	runApplication<NsMarket002Application>(*args)
}
