package com.example.composeui.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimationTwo(modifier: Modifier = Modifier) {
    var isClicked by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (isClicked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
        label = "Color color",
    )
    val animatedSize by animateDpAsState(
        targetValue = if (isClicked) 400.dp else 200.dp,
        label = "Card size",
//        animationSpec = tween(durationMillis = 1000,
//        delayMillis = 500,
        animationSpec = spring(
            dampingRatio = 0.33f,
            stiffness = 500f
        )
//            easing = spring(stiffness = 5f, dampingRatio = 0.9f))
        )

    val animatedOffset by animateIntOffsetAsState(
        targetValue = if (isClicked) IntOffset(0,-200) else IntOffset(10,10),
        label = "Offset",
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .offset { animatedOffset }
                .size(animatedSize),
            colors = CardDefaults.cardColors(
                containerColor = animatedColor
            )
        ) {
            Column (
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Box(modifier = Modifier.background(Color.Red,shape = MaterialTheme.shapes.large)
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 1000,
                            delayMillis = 500
                        )
                    ).size(if (isClicked) 200.dp else 100.dp))


            }
        }
            Button(onClick = { isClicked = !isClicked }) {
                Text(text = "Animate color")
            }
        }
    }
