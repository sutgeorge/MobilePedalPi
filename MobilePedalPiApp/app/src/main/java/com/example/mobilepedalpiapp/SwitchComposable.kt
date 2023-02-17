package com.example.mobilepedalpiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
