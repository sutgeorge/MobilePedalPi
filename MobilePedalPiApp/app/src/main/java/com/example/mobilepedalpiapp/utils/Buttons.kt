package com.example.mobilepedalpiapp.utils

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun ButtonWithColor(text: String, onClick: () -> Unit, width: Dp, height: Dp){
    Button(
        modifier = Modifier.size(width = width, height = height),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
    ) {
        Text(text = text, color = Color.White)
    }
}
