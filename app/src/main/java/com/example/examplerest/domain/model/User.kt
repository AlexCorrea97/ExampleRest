package com.example.examplerest.domain.model

data class User(
    val imageProfile: String,
    val name: String,
    val email: String,
    val birthday: String,
    val address: String,
    val phone: String,
    val password: String
)
