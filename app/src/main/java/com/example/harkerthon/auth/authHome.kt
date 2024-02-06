package com.example.harkerthon


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Down
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Up
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


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

    LaunchedEffect(isAnimate.value) {
        if (isAnimate.value) {
            delay(5000)
            //isAnimate.value = !isAnimate.value
        // Adjust the delay time as needed (1000 milliseconds = 1 second)
        }

    }


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
        CircleCanvas(if (targetState) 350 else 1000)
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



