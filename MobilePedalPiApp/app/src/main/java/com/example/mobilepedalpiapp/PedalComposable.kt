package com.example.mobilepedalpiapp

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mobilepedalpiapp.ui.theme.DarkRed
import com.example.mobilepedalpiapp.ui.theme.DarkerGrey

@Composable
fun PedalComposable() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.pedal_template),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.9f),
        )
        SwitchComposable()
    }
}

@Composable
fun SwitchComposable() {
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
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun KnobComposable() {

}