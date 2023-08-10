package com.example.examplerest.data.mapper

import com.example.examplerest.data.dto.UserResponse
import com.example.examplerest.domain.model.User

fun UserResponse.toUser(): User{
    val user = this.results.first()
    with(user){
        return User(
            name = "${name.title} ${name.first} ${name.last}",
            imageProfile = picture.large,
            email = email,
            birthday = dob.date,
            address = "${location.street} PC: ${location.postcode}. ${location.city}, ${location.country}, ${location.state}",
            phone = phone,
            password = login.password


        )
    }

}