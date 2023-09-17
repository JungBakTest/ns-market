package com.market.board.domain.entity


import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
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
    ){

}
