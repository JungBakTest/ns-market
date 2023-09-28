package com.market.domain.entity

import com.market.domain.repository.CategoryRepository
import javax.persistence.*

@Entity
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String = "",

    @ManyToOne
    val parentCategory: Category? = null,

    @OneToMany(mappedBy = "parentCategory", cascade = [CascadeType.ALL])
    val subCategories: MutableList<Category> = mutableListOf()

)