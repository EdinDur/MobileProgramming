package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hawkbarbershop.ui.theme.Red500
import com.example.hawkbarbershop.ui.theme.screen.navigation.NavigationDestination

object UserProfileDestination: NavigationDestination {
    override val route = "userprofile"
    override val title = "UserProfile"
}

@Composable
fun UserProfileScreen() {
    val name = remember { mutableStateOf("Vildan Kadrić") }
    val email = remember { mutableStateOf("vildan.kadric@stu.ibu.edu.ba") }
    val phone = remember { mutableStateOf("+38762333333") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(262.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.barbershop_black_white),
                    contentDescription = "First Picture",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(262.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.DarkGray),
                                startY = 250f,
                                endY = 700f
                            )
                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.vildan),
                    contentDescription = "User picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.White, shape = CircleShape)
                        .align(Alignment.Center) // Center the user picture
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "Vildan Kadrić",
                    color = Red500,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Red500,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
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
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = {
                        Text(
                            text = "Name",
                            color = Color.White
                        )
                    },
                    colors = textFieldColors
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email.value,
                    onValueChange = {},
                    label = {
                        Text(
                            text = "Email Address",
                            color = Color.White
                        )
                    },
                    colors = textFieldColors
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = phone.value,
                    onValueChange = {},
                    label = {
                        Text(
                            text = "Phone Number",
                            color = Color.White
                        )
                    },
                    colors = textFieldColors
                )
                Spacer(modifier = Modifier.height(32.dp))
                Box(
                    modifier = Modifier.fillMaxSize().padding(top = 40.dp),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        onClick = { /* Handle SAVING */ },
                        modifier = Modifier
                            .height(50.dp)
                            .width(200.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Red500)
                    ) {
                        Text("SAVE", fontSize = 16.sp, color = Color.White)
                    }
                }
            }
        }
    }
}
