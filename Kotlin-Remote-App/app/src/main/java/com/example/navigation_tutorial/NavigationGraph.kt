package com.example.navigation_tutorial

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(
            route = Screen.Main.route
        ) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.SinglePedal.route
        ) {
            SinglePedalScreen(navController = navController)
        }

        composable(
            route = Screen.MultiplePedal.route
        ) {
            MultiplePedalScreen(navController = navController)
        }
    }
}