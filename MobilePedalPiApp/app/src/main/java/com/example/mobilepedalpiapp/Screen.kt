package com.example.mobilepedalpiapp

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object FirstScreen: Screen("first_screen")
    object SecondScreen: Screen("second_screen")
}