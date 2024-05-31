package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hawkbarbershop.ui.theme.Red500
import com.example.hawkbarbershop.ui.theme.screen.navigation.NavigationDestination

object NotificationDestination: NavigationDestination {
    override val route = "notifications"
    override val title = "Notifications"
}

@Composable
fun NotificationScreen(){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(rememberScrollState()),
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(262.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.barbershop_black_white),
                    contentDescription = "First Picture",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(262.dp)
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
            }
            Text(
                text = "Notifications",
                fontSize = 28.sp,
                color = Red500,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Red500,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(68.dp)
                        .padding(start = 8.dp)
                        .border(width = 1.dp, color = Color.White, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column (

                ){
                    Text(text = "Appointment upcoming!", color = Color.LightGray,fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "You have appointment 2/6/2024 at 4:00 PM hours. Please respect the agreed time!", color = Color.LightGray, fontSize = 12.sp, style = TextStyle(lineHeight = 16.sp))
                }
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(68.dp)
                        .padding(start = 8.dp)
                        .border(width = 1.dp, color = Color.White, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column (

                ){
                    Text(text = "Appointment tomorrow!", color = Color.LightGray,fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "We remind you of tomorrow's appointment at 4:00 PM o'clock If you can't make it, please cancel on time!", color = Color.LightGray, fontSize = 12.sp, style = TextStyle(lineHeight = 16.sp)  )
                }
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(68.dp)
                        .padding(start = 8.dp)
                        .border(width = 1.dp, color = Color.White, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column (

                ){
                    Text(text = "Appointment reserved!", color = Color.LightGray,fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "You have successfully booked an appointment 2/6/2024 at 4 PM hours. Please respect the agreed time!", color = Color.LightGray, fontSize = 12.sp, style = TextStyle(lineHeight = 16.sp)  )
                }
            }
        }
    }
}