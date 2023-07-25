package com.example.mobilepedalpiapp

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SwitchComposable() {
    var switchState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .fillMaxHeight(0.2f)
            .absoluteOffset(x = 40.dp, y = 440.dp)
            .padding(bottom = 25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.black_plastic),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    if (switchState.value) {

                        switchState.value = false;
                    } else {

                        switchState.value = true;
                    }
                },
            contentScale = ContentScale.FillBounds
        )
        CableComposable()
    }
}


@Composable
fun CableComposable() {
    val visible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(animationSpec = tween(durationMillis = 200)) { fullWidth ->
            // Offsets the content by 1/3 of its width to the left, and slide towards right
            // Overwrites the default animation with tween for this slide animation.
            -fullWidth / 3
        },
        exit = slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
            500
        }
    ) {
        // Content that needs to appear/disappear goes here:
        Image(
            painter = painterResource(id = R.drawable.cable),
            contentDescription = null,
            modifier = Modifier
        )
    }
}


