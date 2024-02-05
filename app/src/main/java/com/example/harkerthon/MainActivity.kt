package com.example.harkerthon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.harkerthon.onbordingPage.OnBoarding
import com.example.harkerthon.ui.theme.HarkerthonTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarkerthonTheme {
                OnBoarding()
            }
        }
    }
}





@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    HarkerthonTheme {
//        Surface (color = Color(0xFF80ED99)){
//            AnimateTheCircle()
//        }
        OnBoarding()
    }
}



