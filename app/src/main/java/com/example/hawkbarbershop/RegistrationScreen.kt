package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hawkbarbershop.ui.theme.Red500
import com.example.hawkbarbershop.ui.theme.Blue700
import com.example.hawkbarbershop.ui.theme.screen.navigation.NavigationDestination

object RegistrationDestination: NavigationDestination {
    override val route = "register"
    override val title = "Register"
}

@Composable
fun RegistrationScreen(
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var registrationError by remember { mutableStateOf<String?>(null) }

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
            Text("REGISTER", fontSize = 28.sp, color = Color.White)
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
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                label = { Text("Surname") },
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
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

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                colors = textFieldColors,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (validateInputs(name, surname, username, email, password, confirmPassword)) {
                        performRegistration()
                        navigateToHome()
                    } else {
                        registrationError = "Please fill in all fields and make sure passwords match. Password must be at least 8 characters long."
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Red500)
            ) {
                Text("Register", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))

            val alreadyRegisteredText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("Already registered? ")
                }
            }

            val loginHereText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Blue700)) {
                    pushStringAnnotation(tag = "LOGIN", annotation = "login")
                    append("Login here!")
                    pop()
                }
            }

            Row {
                ClickableText(
                    text = alreadyRegisteredText,
                    onClick = { /* No-op */ }
                )
                Spacer(modifier = Modifier.width(4.dp))
                ClickableText(
                    text = loginHereText,
                    onClick = { offset ->
                        loginHereText.getStringAnnotations(tag = "LOGIN", start = offset, end = offset)
                            .firstOrNull()?.let {
                                // Navigate to login screen
                                navigateToLogin()
                            }
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            registrationError?.let { error ->
                Text(
                    text = error,
                    fontSize = 16.sp,
                    color = Color.Red,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private fun validateInputs(
    name: String,
    surname: String,
    username: String,
    email: String,
    password: String,
    confirmPassword: String
): Boolean {
    if (name.isBlank() || surname.isBlank() || username.isBlank() || email.isBlank() ||
        password.isBlank() || confirmPassword.isBlank()
    ) {
        return false
    }
    if (password != confirmPassword) {
        return false
    }
    if (password.length < 8) {
        return false
    }
    return true
}

private fun performRegistration() {
    // Your registration logic here
    // This could involve making a network request to register the user
}
