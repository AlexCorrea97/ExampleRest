package com.example.examplerest.ui.presentation.home_profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.example.examplerest.R
import com.example.examplerest.ui.presentation.BottomAppBarMenu
import com.example.examplerest.ui.presentation.StatusIndicator
import com.example.examplerest.ui.theme.Green


enum class InfoType {
    User,
    Email,
    Birthday,
    Address,
    Phone,
    Password
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(homeViewModel: HomeViewModel) {
    homeViewModel.getUser()
    val loading by homeViewModel.isLoading.observeAsState()
    val userState by homeViewModel.userState.observeAsState()
    var selectedItem: BottomAppBarMenu by remember { mutableStateOf(BottomAppBarMenu.Profile) }
    val items = listOf(
        BottomAppBarMenu.Profile,
        BottomAppBarMenu.Email,
        BottomAppBarMenu.Birthday,
        BottomAppBarMenu.Address,
        BottomAppBarMenu.Phone,
        BottomAppBarMenu.Password
    )
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier.fillMaxWidth().height(48.dp)
            ) {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = item == selectedItem,
                        onClick = {
                            selectedItem = item
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.name,
                                tint = if (item == selectedItem) com.example.examplerest.ui.theme.Green else Color.Gray
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        if (loading == true) {
            CircularProgressIndicator()
        } else {
            HomeAllContentView(
                userState = userState,
                selectedItem = selectedItem,
                Modifier.fillMaxSize().padding(paddingValues),
                homeViewModel
            )
        }
    }
}

@Composable
fun HomeContentView(description: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(35.dp)) {
        Text(
            description,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            value,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif
        )
    }
}


@Composable
fun HomeAllContentView(
    userState: UserViewState?,
    selectedItem: BottomAppBarMenu,
    modifier: Modifier,
    homeViewModel: HomeViewModel,
) {
    Column(
        modifier = modifier,
    ) {
        Image(
            painter = rememberAsyncImagePainter(userState!!.imageProfile),
            contentDescription = "profileImage",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(24.dp)
                .width(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillWidth
        )
        when (selectedItem) {
            BottomAppBarMenu.Address -> HomeContentView("My address is", userState!!.address)
            BottomAppBarMenu.Birthday -> HomeContentView("My birthday is", userState!!.birthday)
            BottomAppBarMenu.Email -> HomeContentView("My email address is", userState!!.email)
            BottomAppBarMenu.Password -> HomeContentView("My password is", userState!!.password)
            BottomAppBarMenu.Phone -> HomeContentView("My phone number is", userState!!.phone)
            BottomAppBarMenu.Profile -> HomeContentView("Hi, my name is", userState!!.name)
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //StatusIndicator(status = 2).StatusIndicatorView()
            Button(
                onClick = { homeViewModel.getUser() },
                modifier = Modifier.height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Green)
            ) {

                Text(
                    "Load new user",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }
        }
    }

}

@Preview
@Composable
fun StatusIndicatorPreview() {
    val indicator = StatusIndicator(
        status = 2
    )
    indicator.StatusIndicatorView()

}

//@Composable
//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//fun PreviewHomeView() {
//    val userviewState = UserViewState(
//        imageProfile = "https://randomuser.me/api/portraits/men/17.jpg",
//        name = "Luis Alejandro Correa Rosado",
//        email = "alex@hotmail.com",
//        birthday = "01/12/1997",
//        address = "1960 First Street",
//        phone = "9990909090",
//        password = "alexalex"
//    )
//    HomeView(userState = userviewState)
//}