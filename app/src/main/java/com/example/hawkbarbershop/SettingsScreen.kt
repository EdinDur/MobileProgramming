package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

object SettingsDestination: NavigationDestination {
    override val route = "settings"
    override val title = "Settings"
}

@Composable
fun SettingsScreen(
    navigateToUserProfile: () -> Unit,
    navigateToMyAccount: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(262.dp)
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
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Settings",
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
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { navigateToUserProfile() }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.user_icon),
                        contentDescription = "user",
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "User profile", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 16.sp)

                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(44.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { navigateToMyAccount() }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.settings_icon),
                        contentDescription = "settings",
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "My account", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 16.sp)

                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(44.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { /* TO DO*/ }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.info_icon),
                        contentDescription = "info",
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "About application", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 16.sp)

                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(44.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { /* TO DO*/ }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.signout_icon),
                        contentDescription = "sign out",
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Sign out", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 16.sp)

                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(44.dp)
                    )
                }
            }
        }
    }
}