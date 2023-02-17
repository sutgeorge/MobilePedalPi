package com.example.mobilepedalpiapp

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController


@Composable
fun MultiplePedalScreen(navController: NavController) {
    val state = rememberDraggableState(onDelta = { delta -> Log.d(ContentValues.TAG, "Dragged $delta") })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                state = state,
                orientation = Orientation.Vertical,
                onDragStarted = {
                    Log.d(ContentValues.TAG, "Drag started")
                    navController.navigate(Screen.SinglePedalScreen.route)
                },
                onDragStopped = { Log.d(ContentValues.TAG, "Drag ended") }
            )
            .padding(WindowInsets.statusBars.asPaddingValues()),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.floor),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}
