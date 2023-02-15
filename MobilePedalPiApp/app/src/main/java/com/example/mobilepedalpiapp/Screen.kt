package com.example.mobilepedalpiapp

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object SinglePedalScreen: Screen("first_screen")
    object MultiplePedalScreen: Screen("second_screen")
}