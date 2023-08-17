package com.market.domain.repository

import com.market.domain.entity.Category
import com.market.domain.entity.MarketBoard
import org.springframework.data.jpa.repository.JpaRepository


interface CategoryRepository : JpaRepository<Category, Long> {
}