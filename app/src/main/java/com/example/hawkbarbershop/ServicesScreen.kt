package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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

object ServicesDestination: NavigationDestination {
    override val route = "services"
    override val title = "Services"
}

@Composable
fun ServiceScreen(
    navigateToServicesAndPrice: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(rememberScrollState())
    ){
        Column(
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
                text = "Choose employee",
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
                        .clickable { navigateToServicesAndPrice() }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.imran),
                        contentDescription = "Imran",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Imran Kočan", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "Master Barber", color = Color.LightGray, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(52.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { navigateToServicesAndPrice() }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.asad),
                        contentDescription = "Assaad",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Muhamad Assaad", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "Master Barber", color = Color.LightGray, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(52.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { navigateToServicesAndPrice() }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.vildan),
                        contentDescription = "Vildan",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Vildan Kadrić", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "Senior Barber", color = Color.LightGray, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(52.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { navigateToServicesAndPrice() }
                        .padding(vertical = 4.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.edin),
                        contentDescription = "Edin",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Edin Duraković", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "Senior Barber", color = Color.LightGray, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow",
                        modifier=Modifier
                            .size(52.dp)
                    )
                }
            }
        }
    }
}