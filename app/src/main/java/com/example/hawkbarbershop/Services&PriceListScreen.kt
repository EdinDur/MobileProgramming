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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

object ServicesAndPriceDestination: NavigationDestination {
    override val route = "servicesandprice"
    override val title = "ServicesAndPrice"
}

@Composable
fun ServicesAndPriceListScreen(
    navigateToSettingAppointments: () -> Unit
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
            Box (
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
                text = "Services & Price list",
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.king_treatment),
                            contentDescription = "King Treatment",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(text = "The royal treatment", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "Duration: 120 minutes", color = Color.LightGray, fontSize = 14.sp)
                        Text(text = "Fixed price: 120.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = { navigateToSettingAppointments() },
                            modifier = Modifier
                                .height(40.dp)
                                .width(220.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Red500)
                        ) {
                            Text("Reserve", fontSize = 14.sp, color = Color.White)
                        }
                    }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.haircut4),
                            contentDescription = "Haircut and beard",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Haircut and beard", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 45 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 30.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments() },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.haircut6),
                            contentDescription = "Haircut",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Haircut", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 30 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 20.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments() },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.haircut1),
                            contentDescription = "Medium / Long haircut",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Medium / Long haircut", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 45 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 25.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments() },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.child),
                            contentDescription = "Children's haircut",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Children's haircut", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 30 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 12.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments()},
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.hairwashing),
                            contentDescription = "Haircut and washing hair",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Haircut and washing hair", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 30 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 25.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments() },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.haircut3),
                            contentDescription = "Beard styling",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Beard styling", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 30 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 15.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments() },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.beardcolloring),
                            contentDescription = "Beard coloring",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(text = "Beard coloring", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = "Duration: 20 minutes", color = Color.LightGray, fontSize = 14.sp)
                            Text(text = "Fixed price: 15.00 BAM", color = Color.LightGray, fontSize = 14.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { navigateToSettingAppointments() },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(220.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Red500)
                            ) {
                                Text("Reserve", fontSize = 14.sp, color = Color.White)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(44.dp))
        }
    }
}
