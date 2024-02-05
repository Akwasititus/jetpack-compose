package com.example.harkerthon.onbordingPage

import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harkerthon.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

//@ExperimentalPagerApi
//@Preview
//@Composable
//fun OnBoarding() {
//    val items = OnBoardingItems.getData()
//    val scope = rememberCoroutineScope()
//    val pageState = rememberPagerState()
//
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        HorizontalPager(
//            count = items.size,
//            state = pageState,
//            modifier = Modifier
//                .fillMaxHeight(0.9f)
//                .fillMaxWidth()
//        ) { page ->
//            OnBoardingItem(items = items[page])
//        }
//        BottomSection(size = items.size, index = pageState.currentPage){
//            if (pageState.currentPage + 1 < items.size) scope.launch {
//                pageState.scrollToPage(items.size - 1)
//            }
//        }
//    }
//}

@ExperimentalPagerApi
@Composable
fun OnBoarding() {
    val items = OnBoardingItems.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Set your image resource or URI here
        Image(
            painter = painterResource(id = R.drawable.original_bg), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )

        Column {
            HorizontalPager(
                count = items.size,
                state = pageState,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            ) { page ->
                OnBoardingItem(items = items[page])
            }

            BottomSection(size = items.size, index = pageState.currentPage) {
                if (pageState.currentPage + 1 < items.size) scope.launch {
                    pageState.scrollToPage(items.size - 1)
                }
            }
        }

    }
}



@Composable
fun BottomSection(size: Int, index: Int,onSkipClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Indicators
        Indicators(size, index)
        TextButton(
            onClick = onSkipClick,
            modifier = Modifier.align(Alignment.CenterEnd),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "Skip", style = MaterialTheme.typography.labelSmall,)
        }
    }
}

@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = 13.dp,
        animationSpec = spring(dampingRatio = Spring.StiffnessLow), label = ""
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) Color( 0XFFF8E2E7) else Color(0xFF19B55C)
            )
    ) {

    }
}

@Composable
fun OnBoardingItem(items: OnBoardingItems) {

    val myContext = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = items.image),
            contentDescription = "Image1",
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp)
                .size(350.dp)
        )


        MySpacer(
            modifier = Modifier.fillMaxWidth(),
            height = 20.dp
        )


        Text(
            text = stringResource(id = items.title),
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))

        ClickableImage(onClick = {
            Toast.makeText(myContext, "My first Jetpack compose app", Toast.LENGTH_LONG).show()
        })
    }
}


@ExperimentalPagerApi
@Composable
fun PreviewFunction(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        OnBoarding()
    }
}
