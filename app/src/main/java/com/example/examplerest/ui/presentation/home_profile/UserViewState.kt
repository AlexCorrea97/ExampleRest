package com.example.examplerest.ui.presentation.home_profile

data class UserViewState(
    val imageProfile: String,
    val name: String,
    val email: String,
    val birthday: String,
    val address: String,
    val phone: String,
    val password: String
)
