package com.market.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class ImgStorage(
    @Id
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val imgId: Long? = null,

    @Column(name = "img_url")
    val imgUrl: String = "",

    @Column(name = "user_id")
    val userId: Long? = null
)
