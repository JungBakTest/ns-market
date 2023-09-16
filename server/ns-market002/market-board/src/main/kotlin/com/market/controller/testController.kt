package com.market.controller

import com.market.domain.entity.Category
import com.market.domain.repository.CategoryRepository
import com.market.domain.repository.MarketBoardRepository
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/api/test")
class testController (
    private val categoryRepository: CategoryRepository,
){
    @GetMapping
    fun test1() : Category{
        val farmProduct =  Category(name = "FarmProduct") //농산물
        val livestockProduct = Category(name = "LivestockProduct") //축산물
        val aquaticProduct = Category(name = "AquaticProduct") //aquatic products
//        electronics.subCategories.addAll(listOf(smartphones, laptops))
//        smartphones.subCategories.addAll(listOf(samsung, apple))

        categoryRepository.save(farmProduct)
        categoryRepository.save(livestockProduct)
        categoryRepository.save(aquaticProduct)
        return farmProduct
    }

    @PostMapping("/test")
    suspend fun test(
        @RequestPart("files") files: MultipartFile,
    ): String
    {
        return files.name
    }
}