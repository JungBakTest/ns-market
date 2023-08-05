package com.market

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
@SpringBootApplication
@ConfigurationPropertiesScan
class NsMarketUserServiceApplication

fun main(args: Array<String>) {
    runApplication<NsMarketUserServiceApplication>(*args)
}
