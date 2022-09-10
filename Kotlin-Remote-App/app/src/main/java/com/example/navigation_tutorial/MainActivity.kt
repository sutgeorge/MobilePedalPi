package com.example.navigation_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation_tutorial.ui.theme.NavigationTutorialTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTutorialTheme {
                navController = rememberNavController()
                SetupNavigationGraph(navController = navController)
            }
        }
    }
}


