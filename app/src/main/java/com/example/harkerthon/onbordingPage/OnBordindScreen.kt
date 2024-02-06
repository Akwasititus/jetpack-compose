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
import androidx.compose.ui.unit.dp
import com.example.harkerthon.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoarding(function: () -> Unit) {
    val items = OnBoardingItems.getData()

    //to managing coroutine scopes,
    val scope = rememberCoroutineScope()

    //is use to manage the state of a pager UI component.
    val pageState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // background image
        Image(
            painter = painterResource(id = R.drawable.original_bg),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )

        Column {

            //a scrolling layout that allows users to flip between items to the left and right.
            HorizontalPager(
                count = items.size, // item count. getting the length of items in the "OnBoardingItems"
                state = pageState, // page state
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            ) { page ->
                OnBoardingItem(items = items[page], function)
            }


            BottomSection(size = items.size, index = pageState.currentPage) {

                //this checks if there is a next page available in a pagination scenario.
                // If there is, it launches a coroutine to scroll to the last page.
                if (pageState.currentPage + 1 < items.size) scope.launch {
                    pageState.scrollToPage(items.size - 1)
                }
            }
        }

    }
}



@Composable
fun BottomSection(
    size: Int,
    index: Int,
    onSkipClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Indicators
        Indicators(size, index) // only "size, index" is called here
        TextButton(
            onClick = onSkipClick, // only "onSkipClick" is called here
            modifier = Modifier.align(Alignment.CenterEnd),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "Skip", style = MaterialTheme.typography.labelSmall)
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
        targetValue = 13.dp, // target value to which the animation will interpolate.
        animationSpec = spring(dampingRatio = Spring.StiffnessLow), // determines the animation behavior.
        label = ""
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
fun OnBoardingItem(items: OnBoardingItems, function: () -> Unit) {
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
            function()
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

//        OnBoarding {
//            isNav.value = !isNav.value
//        }
    }
}
