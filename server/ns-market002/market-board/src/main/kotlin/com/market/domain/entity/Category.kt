package com.market.domain.entity

import com.market.domain.repository.CategoryRepository
import javax.persistence.*



//fun main(){
//    val electronics = Category(name = "Electronics")
//    val smartphones = Category(name = "Smartphones", parentCategory = electronics)
//    val laptops = Category(name = "Laptops", parentCategory = electronics)
//    val samsung = Category(name = "Samsung", parentCategory = smartphones)
//    val apple = Category(name = "Apple", parentCategory = smartphones)
//
//    electronics.subCategories.addAll(listOf(smartphones, laptops))
//    smartphones.subCategories.addAll(listOf(samsung, apple))
//
//    val catetoryRepository: CategoryRepository
//
//    catetoryRepository.save(electronics)
//}

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