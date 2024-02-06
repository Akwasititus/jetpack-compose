package com.example.harkerthon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.harkerthon.ui.theme.HarkerthonTheme
import composables.MyApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarkerthonTheme {
                MyApp()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    HarkerthonTheme {
        MyApp()
    }
}



