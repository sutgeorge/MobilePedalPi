package com.example.mobilepedalpiapp

import androidx.compose.animation.*
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
val tweenSpec = tween<IntOffset>(durationMillis = 1000, easing = CubicBezierEasing(0.08f,0.93f,0.68f,1.27f))

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
                slideOutVertically(targetOffsetY = { -2000 }, animationSpec = springSpec)
            },
        ) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.FirstScreen.route,
            enterTransition = {
                slideInVertically(initialOffsetY = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = {
                slideOutVertically(targetOffsetY = { -2000 }, animationSpec = springSpec)
            },
        ) {
            FirstScreen(navController = navController)
        }
    }
}

@Composable
fun MainText() {
    Text(
        "MobilePedalPi",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        "A variety of guitar pedal effects and combinations of them enabled by " +
                "Bluetooth communication with a soundcard-equipped Raspberry Pi",
        modifier = Modifier.padding(20.dp),
        fontSize = 20.sp
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSliding(navController: NavController) {
    val pagerState = rememberPagerState()

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % guitarImages,
                animationSpec = tween(600)
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f),
                count = guitarImages
            ) { page ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray)
                    ) {
                        Image(
                            painter = painterResource(
                                id = when (page) {
                                    0 -> R.drawable.sg
                                    1 -> R.drawable.gretsch
                                    2 -> R.drawable.strat
                                    else -> R.drawable.sg
                                }
                            ),
                            contentDescription = "Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .weight(2f),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MainText()
                ButtonWithColor(text = "Start jamming",
                    onClick = {
                        navController.navigate(Screen.FirstScreen.route)
                    }, width = 200.dp, height = 80.dp
                )
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    AutoSliding(navController)
}

@Composable
fun FirstScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello world!")
    }
}
