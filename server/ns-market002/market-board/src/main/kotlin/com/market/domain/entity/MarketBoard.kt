package com.market.domain.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*



//@Table(name = "marketboard")
@Entity
@Table
class MarketBoard (
    @Id
    @Column(name = "borad_id)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val boardId: Long? = null,

    @Column(name = "user_id")
    val userId: Long,

    @Column
    val title:String,

    @Column
    val content: String,

    @Column(name = "img_id")
    val imgId: Long,

    @CreatedDate
    @Column(name = "create_at")
    val createdAt: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "update_at")
    val updateAt: LocalDateTime? = null,

){


}


fun main(){
    val marketBoard = MarketBoard(
        userId = 1,
        title = "test",
        content = "testtest",
        imgId = 1,
    )

    println(marketBoard)
}