package com.example.harkerthon


import android.content.Context
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Down
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Up
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.lang.annotation.Native


@Composable
fun CircleCanvas(y: Int) {
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        drawCircle(
            color = Color(0xFF57CC99),
            radius = 400.dp.toPx(),
            center = Offset(200.dp.toPx(), y.dp.toPx())
        )
    }
}


@Composable
fun AnimateTheCircle(
    isAnimate: MutableState<Boolean> = remember { mutableStateOf(true) },
) {

    // AnimatedContent composable
    AnimatedContent(
        targetState = isAnimate.value,
        label = "",
        contentAlignment = Alignment.Center,
        transitionSpec = {
            slideIntoContainer(
                towards = Up,
                tween(1000, easing = EaseIn)
            ).togetherWith(
                slideOutOfContainer(
                    towards = Down,
                    tween(1000, easing = EaseOut)
                )
            )
        }
    ) { targetState ->
        CircleCanvas(if (targetState) 250 else 950)
        if (targetState) {
            LoginPage{
                isAnimate.value = !isAnimate.value
            }
        }else{
            RegisterPage{
                isAnimate.value = !isAnimate.value
            }
        }
    }
}



