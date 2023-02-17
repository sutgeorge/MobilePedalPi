package com.example.mobilepedalpiapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilepedalpiapp.utils.ButtonWithColor
import com.example.mobilepedalpiapp.utils.guitarImages
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioMediumBouncy)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController();

    AnimatedNavHost(navController = navController, startDestination = Screen.MainScreen.route) {

        composable(
            route = Screen.MainScreen.route,
            enterTransition = {
                slideInVertically(initialOffsetY = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = {
                slideOutVertically(targetOffsetY = { -1000 }, animationSpec = springSpec)
            },
        ) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.SinglePedalScreen.route,
            enterTransition = {
                slideInVertically(initialOffsetY = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = {
                slideOutVertically(targetOffsetY = { -2000 }, animationSpec = springSpec)
            },
        ) {
            SinglePedalScreen(navController = navController)
        }
        
        composable(
            route = Screen.MultiplePedalScreen.route,
            enterTransition = {
                slideInVertically(initialOffsetY = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = {
                slideOutVertically(targetOffsetY = { -2000 }, animationSpec = springSpec)
            },
        ) {
            MultiplePedalScreen(navController = navController)
        }
    }
}

