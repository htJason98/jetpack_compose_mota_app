package com.jason.mota.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jason.mota.ui.login.LoginScreen

@ExperimentalAnimationApi
@Composable
fun NavigationHome() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationDestinations.welcomeScreen) {
        composable(route = NavigationDestinations.welcomeScreen) {
            WelcomeScreen(navController)
        }
        composable(route = NavigationDestinations.loginScreen) {
            LoginScreen(navController)
        }
    }
}

object NavigationDestinations {
    const val welcomeScreen = "WelcomeScreen"
    const val loginScreen = "LoginScreen"
    const val historyScreen = "HistoryScreen"
}