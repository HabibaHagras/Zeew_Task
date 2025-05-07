package com.example.zeew_task.models

data class CartItem(
    val title: String,
    val quantity: Int,
    val price: String,
    val imageUrl: String?,
    val details: String? = null
)
