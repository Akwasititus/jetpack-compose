package com.example.harkerthon.onbordingPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.harkerthon.R

//=========================
// Onboarding Model
//========================
class OnBoardingItems(
    val image: Int,
    val title: Int,
    val buttonName: Int
) {
    //"companion object" this allows you to define properties
    // and methods that are associated with the class itself,
    companion object{
        fun getData(): List<OnBoardingItems>{
            return listOf(
                OnBoardingItems(R.drawable.graphic, R.string.titleScreen1, R.string.buttonName),
                OnBoardingItems(R.drawable.graphic2, R.string.titleScreen2, R.string.buttonName),
                OnBoardingItems(R.drawable.graphic1, R.string.titleScreen3, R.string.buttonName)
            )
        }
    }
}


//=========================
// SizeBox
//========================
@Composable
fun MySpacer(
    modifier: Modifier,
    height: Dp
){
    Spacer(modifier = modifier.height(height))
}

@Composable
fun ClickableImage(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.button),
        contentDescription = "Image1",
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .size(250.dp)
            .clickable(onClick = onClick),
        contentScale = ContentScale.Fit // Adjust content scale as needed
    )
}




