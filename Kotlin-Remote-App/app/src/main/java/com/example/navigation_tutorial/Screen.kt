package com.example.navigation_tutorial

sealed class Screen(val route: String) {
    object Main: Screen(route = "main_screen")
    object SinglePedal: Screen(route = "single_pedal_screen")
    object MultiplePedal: Screen(route = "multiple_pedal_screen")
}
