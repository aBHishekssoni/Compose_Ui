package com.example.composeui.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.node.CanFocusChecker.enter
import androidx.compose.ui.unit.dp

@Composable
fun AnimationOne(modifier: Modifier = Modifier) {
    var inExpanded by remember {
        mutableStateOf(false)
    }
    Column(modifier = modifier
        .fillMaxSize()) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red, shape = MaterialTheme.shapes.extraLarge)
                .height(30.dp)
                .clickable {
                    inExpanded = !inExpanded
                }
        ){
            androidx.compose.animation.AnimatedVisibility(visible = inExpanded,
            enter = fadeIn(),
                exit = slideOutVertically(
                    targetOffsetY={-it-500},
                    animationSpec = tween(durationMillis = 500)
                ),

            ) {
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                        .height(30.dp)
                )
            }

        }
    }

}