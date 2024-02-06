package composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.example.harkerthon.auth.AuthHome
import com.example.harkerthon.onbordingPage.OnBoarding
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApp(
    isNav: MutableState<Boolean> = remember { mutableStateOf(true) },
) {

    // AnimatedContent composable
    AnimatedContent(
        targetState = isNav.value,
        label = "" ,
        transitionSpec = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                tween(1000, easing = Ease)
            ).togetherWith(
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    tween(1000, easing = Ease)
                )
            )
        }
    ) { targetState ->
        if (targetState) {
            OnBoarding{
                isNav.value = !isNav.value
            }
        }else{
            AuthPage()
        }
    }
}


@Composable
fun AuthPage(){
    Surface (color = Color(0xFF80ED99)){
        AuthHome()
    }
}