package com.market.domain.entity

import com.market.domain.repository.MarketBoardRepository
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*

@Table(name = "marketboard")
@Entity
class MarketBoard (

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var boardId: Long? = null,

    @Column(name = "user_id")
    var userId: Long = 0,

    @Column
    var title: String = "",

    @Column
    var content: String = "",

    @CreatedDate
    @Column(name = "create_at")
    var createdAt: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "update_at")
    var updateAt: LocalDateTime? = null,

    @Column(name = "view_count")
    var viewCount: Long = 0,

    @Column
    var category : Long = 0,

    @Column
    var price: Long = 0,

    // No-arguments constructor
    )
//@Entity
//@Table(name = "market_board")
//class MarketBoard (
//
//    @Id
//    @Column(name = "board_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val boardId: Long? = null,
//
//    @Column(name = "user_id")
//    val userId: Long,
//
//    @Column
//    val title: String,
//
//    @Column
//    val content: String,
//
//    @Column(name = "img_id")
//    val imgId: Long,
//
//    @CreatedDate
//    @Column(name = "create_at")
//    val createdAt: LocalDateTime? = null,
//
//    @LastModifiedDate
//    @Column(name = "update_at")
//    val updateAt: LocalDateTime? = null,
//
//    @Column(name = "view_count")
//    val viewCont: Long = 0,
//
//    @Column
//    val category: Long,
//
//)




