package com.jason.mota.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jason.mota.ui.home.WelcomeScreen
import com.jason.mota.ui.home.view.HomeScreen
import com.jason.mota.ui.login.RegistrationScreen
import com.jason.mota.ui.login.view.LoginScreen

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
        composable(route = NavigationDestinations.registrationScreen) {
            RegistrationScreen(navController)
        }
        composable(route = NavigationDestinations.homeScreen) {
            HomeScreen(navController)
        }
    }
}

object NavigationDestinations {
    const val welcomeScreen = "WelcomeScreen"
    const val loginScreen = "LoginScreen"
    const val registrationScreen = "RegistrationScreen"
    const val homeScreen = "HomeScreen"
}