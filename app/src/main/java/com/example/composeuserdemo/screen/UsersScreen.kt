package com.example.composeuserdemo.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeuserdemo.model.Users
import com.example.composeuserdemo.viewmodel.DetailsViewModel


@Composable
fun UsersScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val usersInfo = detailsViewModel.users.collectAsState()

    Log.d("UsersScreen", "Users: ${usersInfo.value}")

    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(usersInfo.value) {
        UserDetails(user = it)
            Log.d("UsersScreen", "Users1: ${usersInfo.value}")
        }
    }
}

@Composable
fun UserDetails(user: Users) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Transparent)
            .border(1.dp, Color(0xFF9C27B0))
    ) {
        Text(
            text = "Name: ${user.name}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Category: ${user.category}",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Email: ${user.info.email}",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Phone: ${user.info.phone}",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Address: ${user.info.address}",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
    }
}
