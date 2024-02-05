package com.example.harkerthon


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import composables.CustomTextField
import composables.LightText

@Composable
fun LoginPage(
    onClickAction: () -> Unit
) {

    //============================================
    // checking screen sizes
    //============================================

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    //=============================================
    //mutable variables for the textFields
    //=============================================
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 100.dp,
                    )
            ) {

                //=======================================
                // welcome text
                //=======================================

                Column {
                    LightText(textName = "Welcome to", fontSize = 25.sp,color = Color.Black)

                    LightText(textName = "Trendify!", fontSize = 60.sp, color = Color(0xFF22577A))

                    LightText(
                        textName = "Explore the latest stocks & track it", fontSize = 15.sp,color = Color.Black,
                        modifier = Modifier.padding(bottom = 32.dp))

                    //=======================================
                    // Text fields
                    //=======================================
                }
                Spacer(modifier = Modifier.height(40.dp))

                Column (
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                )

                {
                    CustomTextField(
                        value = email,
//                       // strokeWidth = 4,
                        label = "email",
                        keyboardType = KeyboardType.Email,
                        onValueChange = { email = it },
                    )

                    CustomTextField(
                        value = email,
                       // strokeWidth = 4,
                        label = "email",
                        keyboardType = KeyboardType.Email,
                        onValueChange = { email = it },
                    )

                    CustomTextField(
                        value = password,
                        label = "password",
                        keyboardType = KeyboardType.Password,
                        visualTransformation = PasswordVisualTransformation(),
                        onValueChange = { password = it },
                    )
                }
                //=======================================
                // forget password
                //=======================================
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LightText(textName = "Forgot Password?", fontSize = 15.sp, color = Color.Black)

                    //=======================================
                    // login bottom
                    //=======================================

                    Button(
                        onClick = {
                            onClickAction()
                                  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(
                                top = 15.dp,
                                end = 25.dp,
                                start = 25.dp
                            )
                    ) {
                        Text("Login")
                    }

                    //EclipsedBox(contentAlignment = Alignment.BottomCenter)

                    //=======================================
                    // signup bottom
                    //=======================================
                    LightText(textName = "or signup", fontSize = 15.sp,color = Color.Black)
                }

//        Text(
//            style = TextStyle(fontSize = 12.sp),
//            text = "Terms & Conditions apply",
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(bottom = 12.dp)
//        )

    }


}