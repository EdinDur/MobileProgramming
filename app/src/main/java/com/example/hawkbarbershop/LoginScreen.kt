package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hawkbarbershop.ui.theme.Red500
import com.example.hawkbarbershop.ui.theme.Blue700
import com.example.hawkbarbershop.ui.theme.screen.navigation.NavigationDestination

object LoginDestination: NavigationDestination {
    override val route = "login"
    override val title = "Login"
}

@Composable
fun LoginScreen(
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(156.dp)
                    .padding(bottom = 16.dp)
            )
            Text("LOGIN", fontSize = 28.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            val textFieldColors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (validateLoginInputs(username, password)) {
                        // Perform login
                        loginError = null
                        navigateToHome()
                    } else {
                        loginError = "Please enter valid credentials."
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Red500)
            ) {
                Text("Login", fontSize = 20.sp, color = Color.White)
            }

            // Display login error, if any
            loginError?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            val notRegisteredText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("Not Registered?")
                }
            }

            val registerHereText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Blue700)) {
                    pushStringAnnotation(tag = "REGISTER", annotation = "register")
                    append("Register here!")
                    pop()
                }
            }

            Row {
                ClickableText(
                    text = notRegisteredText,
                    onClick = { /* No-op */ }
                )
                Spacer(modifier = Modifier.width(4.dp))
                ClickableText(
                    text = registerHereText,
                    onClick = { offset ->
                        registerHereText.getStringAnnotations(tag = "REGISTER", start = offset, end = offset)
                            .firstOrNull()?.let {
                                // Navigate to register screen
                                navigateToRegister()
                            }
                    }
                )
            }
        }
    }
}


// Function to validate login inputs
private fun validateLoginInputs(username: String, password: String): Boolean {
    // Validate that both username and password are not blank
    return username.isNotBlank() && password.isNotBlank()
}
