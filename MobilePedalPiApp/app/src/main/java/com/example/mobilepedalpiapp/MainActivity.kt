package com.example.mobilepedalpiapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilepedalpiapp.ui.theme.MobilePedalPiAppTheme
import com.example.mobilepedalpiapp.utils.guitarImages
import com.example.mobilepedalpiapp.utils.ButtonWithColor;
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobilePedalPiAppTheme {
                AutoSliding()
            }
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
fun AutoSliding() {
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
                            .background(LightGray)
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

                                }, width = 200.dp, height=80.dp)
            }
        }

    }
}


