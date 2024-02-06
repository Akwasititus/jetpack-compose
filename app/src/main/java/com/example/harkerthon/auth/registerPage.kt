package com.example.harkerthon

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import composables.CustomTextField
import composables.LightText
import composables.OriginalText

@Composable
fun RegisterPage(
    onClickAction: () -> Unit
) {

    //=============================================
    //mutable variables for the textFields
    //=============================================
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val myContext = LocalContext.current


        //=======================================
        // outer curred container
        //=======================================

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
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
                    OriginalText(textName = stringResource(id = R.string.welcomeText), fontSize = 25.sp,color = Color.Black, )

                    OriginalText(textName = stringResource(id = R.string.trendify), fontSize = 60.sp,color = Color(0xFF22577A))

                    OriginalText(
                        textName = stringResource(id = R.string.explore),
                        fontSize = 15.sp,color = Color.Black,
                        modifier = Modifier.padding(bottom = 32.dp)
                    )

                    //=======================================
                    // Text fields
                    //=======================================
                }

                Spacer(modifier = Modifier.height(40.dp))
                Column {
                    CustomTextField(
                        value = name,
                        strokeWidth = 4,
                        label = "Name",
                        keyboardType = KeyboardType.Text,
                        onValueChange = { name = it },
                    )

                    CustomTextField(
                        value = email,
                        strokeWidth = 4,
                        label = "Enter Email",
                        keyboardType = KeyboardType.Email,
                        onValueChange = { email = it },
                    )

                    CustomTextField(
                        value = password,
                        strokeWidth = 4,
                        label = "Create Password",
                        keyboardType = KeyboardType.Password,
                        visualTransformation = PasswordVisualTransformation(),
                        onValueChange = { password = it },
                    )
                    Spacer(modifier = Modifier.height(70.dp))
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                Toast.makeText(myContext, "Email: $email Password: $password ", Toast.LENGTH_LONG).show()

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
                            Text("Register")
                        }

                        //=======================================
                        // signup bottom
                        //=======================================
                        OriginalText(textName = "or signup", fontSize = 15.sp,color = Color.Black, onClickAction = {onClickAction()})

                    }


                }
            }
        }

