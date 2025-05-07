package com.example.zeew_task.models

data class Addresse(
    val id: Long,
    val country: String,
    val address1: String,
    val address2: String?,
    val phone: String,
    val default: Boolean
)
