package com.example.composeui.ui.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AnimationThree(modifier: Modifier = Modifier) {
    val infiniteTextTransition = rememberInfiniteTransition(
        label = "infiniteTextTransition"
    )
    val animateColor = infiniteTextTransition.animateColor(
        initialValue = Color(0xFF00F8A65),
        targetValue = Color(0xFFFF00FF),
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
                    repeatMode = RepeatMode.Reverse,
        ),
        label = "animateColor"
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Animation 3",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.ExtraBold,
//            color = animateColor
        )
        Box(modifier = Modifier.padding(16.dp)){

        }

    }
}