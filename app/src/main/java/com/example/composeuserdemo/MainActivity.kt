package com.example.composeuserdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeuserdemo.api.UserApi
import com.example.composeuserdemo.screen.CategoryScreen
import com.example.composeuserdemo.screen.UsersScreen
import com.example.composeuserdemo.ui.theme.ComposeUserDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userApi: UserApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeUserDemoTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, "category") {
        composable(route = "category") {
            CategoryScreen() {
                navController.navigate("detail/${it}")
            }
        }
        composable(
            route = "detail/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )) {
            UsersScreen()
        }
    }
}