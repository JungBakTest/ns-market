package com.market.domain.enum

enum class IssuePriority {
    LOW, MEDIUM, HIGH;

    companion object{
        operator fun invoke(priority: String) = valueOf(priority.uppercase())
    }
}

//fun main() {
//    val priority = IssuePriority("low") // LOW
//    println(priority)
//}