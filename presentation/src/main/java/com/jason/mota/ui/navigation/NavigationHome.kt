package com.jason.mota.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.jason.mota.ui.home.view.HomeScreen
import com.jason.mota.ui.login.view.LoginScreen
import com.jason.mota.ui.login.view.RegistrationScreen
import com.jason.mota.ui.login.view.WelcomeScreen

@ExperimentalAnimationApi
@Composable
fun NavigationHome() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = NavigationDestinations.welcomeScreen) {
        composable(
            route = NavigationDestinations.welcomeScreen,
            popEnterTransition = { initial, _ ->
                popEnterTransition(initial = initial, routeScreen = NavigationDestinations.loginScreen)
            }
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = NavigationDestinations.loginScreen,
            enterTransition = { initial, _ ->
                enterTransition(initial = initial, routeScreen = NavigationDestinations.welcomeScreen)
            },
            popEnterTransition = { initial, _ ->
                popEnterTransition(initial = initial, routeScreen = NavigationDestinations.registrationScreen)
            }
        ) {
            LoginScreen(navController)
        }
        composable(
            route = NavigationDestinations.registrationScreen,
            enterTransition = { initial, _ ->
                enterTransition(initial = initial, routeScreen = NavigationDestinations.loginScreen)
            },
            popEnterTransition = { initial, _ ->
                popEnterTransition(initial = initial, routeScreen = NavigationDestinations.homeScreen)
            }
        ) {
            RegistrationScreen(navController)
        }
        composable(
            route = NavigationDestinations.homeScreen,
            enterTransition = { initial, _ ->
                enterTransition(initial = initial, routeScreen = NavigationDestinations.registrationScreen)
            },
//            popEnterTransition = { initial, _ ->
//                popEnterTransition(initial = initial, routeScreen = NavigationDestinations.homeScreen)
//            }
        ) {
            HomeScreen(navController)
        }
    }
}

@ExperimentalAnimationApi
fun popEnterTransition(initial: NavBackStackEntry, routeScreen: String): EnterTransition? {
    return when (initial.destination.route) {
        routeScreen ->
            slideInHorizontally(
                initialOffsetX = { -300 },
                animationSpec = tween(200)
            ) + fadeIn(animationSpec = tween(300))
        else -> null
    }
}

@ExperimentalAnimationApi
fun exitTransition(initial: NavBackStackEntry, routeScreen: String): ExitTransition? {
    return when (initial.destination.route) {
        routeScreen ->
            slideOutHorizontally(
                targetOffsetX  = { -300 },
                animationSpec = tween(200)
            ) + fadeOut(animationSpec = tween(300))
        else -> null
    }
}

@ExperimentalAnimationApi
fun enterTransition(initial: NavBackStackEntry, routeScreen: String): EnterTransition? {
    return when (initial.destination.route) {
        routeScreen ->
            slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(200)
            ) + fadeIn(animationSpec = tween(300))
        else -> null
    }
}

object NavigationDestinations {
    const val welcomeScreen = "WelcomeScreen"
    const val loginScreen = "LoginScreen"
    const val registrationScreen = "RegistrationScreen"
    const val homeScreen = "HomeScreen"
}