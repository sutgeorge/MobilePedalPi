package com.example.mobilepedalpiapp

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PedalComposable() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.6f)
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = Brush.horizontalGradient(
                    0.0f to Color.Black,
                    0.05f to Color.DarkGray,
                    0.1f to Color.LightGray,

                    0.95f to Color.DarkGray,
                    1.0f to Color.Black,
                    startX = 0f,
                    endX = Float.POSITIVE_INFINITY
                )
            ),
        contentAlignment = Alignment.Center
    ) {}


}