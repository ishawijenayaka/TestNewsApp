package com.example.testnewsapp.ui.commanComponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

// enter animation for fade in
@Composable
fun EnterAnimation(duration: Int, content: @Composable AnimatedVisibilityScope.() -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(
            initialAlpha = 0.01f,
            animationSpec = tween(duration)
        ),
        exit = fadeOut(
            animationSpec = tween(duration)
        ),
        content = content
    )
}