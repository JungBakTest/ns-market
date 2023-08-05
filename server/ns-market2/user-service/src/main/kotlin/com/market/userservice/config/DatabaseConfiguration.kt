package com.market.userservice.config

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration
import dev.miku.r2dbc.mysql.MySqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import java.time.Duration

class DatabaseConfiguration : AbstractR2dbcConfiguration(){

    override fun connectionFactory(): ConnectionFactory
        = MySqlConnectionFactory.from(
            MySqlConnectionConfiguration.builder()
                .host("127.0.0.1")
                .username("root")
                .port(3306)
                .password("root")
                .database("db_example")
                .connectTimeout(Duration.ofSeconds(3))
                .useServerPrepareStatement()
                .build()
        )
}