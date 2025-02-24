package com.example.productapp.ui.model

import java.util.Date

data class Comment(
    val id: Int,
    val username: String,
    val comment: String,
    val date: Date,
    val productId: Int
)


