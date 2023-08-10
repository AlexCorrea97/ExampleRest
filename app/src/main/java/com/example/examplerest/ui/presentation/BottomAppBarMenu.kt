package com.example.examplerest.ui.presentation

import androidx.annotation.DrawableRes
import com.example.examplerest.R

sealed class BottomAppBarMenu(
    val name: String,
    @DrawableRes val icon: Int,
) {
    object Profile : BottomAppBarMenu(name = "Profile", icon = R.drawable.person_icon)
    object Email : BottomAppBarMenu(name = "Email", icon = R.drawable.email_icon)
    object Birthday : BottomAppBarMenu(name = "Birthday", icon = R.drawable.calendar_icon)
    object Address : BottomAppBarMenu(name = "Address", icon = R.drawable.street_icon)
    object Phone : BottomAppBarMenu(name = "Phone", icon = R.drawable.phone_icon)
    object Password : BottomAppBarMenu(name = "Password", icon = R.drawable.security_icon)


}
