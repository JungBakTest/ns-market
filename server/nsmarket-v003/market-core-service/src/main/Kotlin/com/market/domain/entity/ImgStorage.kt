package com.market.domain.entity

import javax.persistence.*

@Entity
class ImgStorage(
    @Id
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val imgId: Long? = null,

    @Column(name = "img_url")
    val imgKey: String = "",

    @Column(name = "user_id")
    val userId: Long? = null,

    @Column(name = "board_id")
    val boardId: Long? = null,
)
