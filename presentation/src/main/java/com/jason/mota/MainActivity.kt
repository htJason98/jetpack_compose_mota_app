package com.jason.mota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.jason.mota.ui.home.NavigationHome
import com.jason.mota.ui.theme.MotaTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationHome()
                }
            }
        }
    }
}