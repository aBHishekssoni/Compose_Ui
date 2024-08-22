package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeui.ui.screen.AnimationOne
import com.example.composeui.ui.screen.AnimationThree
import com.example.composeui.ui.screen.AnimationTwo
import com.example.composeui.ui.screen.heroAnimation
import com.example.composeui.ui.theme.ComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    heroAnimation(
                       modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}
