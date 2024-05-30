package com.example.hawkbarbershop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hawkbarbershop.ui.theme.Red500
import com.example.hawkbarbershop.ui.theme.screen.navigation.NavigationDestination
import java.text.SimpleDateFormat
import java.util.*

object SettingAppointmentsDestination: NavigationDestination {
    override val route = "settingappointment"
    override val title = "SettingAppointment"
}

@Composable
fun SettingAppointmentScreen() {
    var selectedDate by remember { mutableStateOf<Date?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Select Date",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            CustomCalendar(
                onDateSelected = { date ->
                    selectedDate = date
                }
            )
            Text(
                text = selectedDate?.let {
                    SimpleDateFormat("EEEE, MMM d, yyyy", Locale.ENGLISH).format(it)
                } ?: "No date selected",
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Red500,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            val timeSlots = generateTimeSlots()

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(timeSlots) { time ->
                    Box(
                        modifier = Modifier
                            .clickable { /*TO DO */ }
                            .padding(8.dp)
                            .width(100.dp)
                            .height(52.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Red500),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = time,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Red500,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            Box(
                modifier = Modifier.fillMaxWidth()
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ){
                        Text(text = "Haircut", color = Color.White, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "15.00 BAM", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                            .padding(end = 8.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.imran),
                            contentDescription = "Imran",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Imran", color = Color.White, fontSize = 16.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "03:30 PM - 04:00 PM", color = Color.White, fontSize = 16.sp)
                    }
                }
            }
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 40.dp),
                contentAlignment = Alignment.Center
            ){
                Button(
                    onClick = { /* Handle registration */ },
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Red500)
                ) {
                    Text("RESERVE", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CustomCalendar(onDateSelected: (Date) -> Unit) {
    val currentDate = Calendar.getInstance()
    val currentMonth = currentDate.get(Calendar.MONTH)
    val currentYear = currentDate.get(Calendar.YEAR)

    var displayedMonth by remember { mutableStateOf(currentMonth) }
    var displayedYear by remember { mutableStateOf(currentYear) }

    var selectedDate by remember { mutableStateOf<Date?>(null) }

    val daysInMonth = getDaysInMonth(displayedMonth, displayedYear)
    val firstDayOfMonth = getFirstDayOfMonth(displayedMonth, displayedYear)

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                if (displayedMonth == 0) {
                    displayedMonth = 11
                    displayedYear--
                } else {
                    displayedMonth--
                }
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous Month", tint = Color.White)
            }
            Text(
                text = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH).format(
                    Calendar.getInstance().apply {
                        set(Calendar.MONTH, displayedMonth)
                        set(Calendar.YEAR, displayedYear)
                    }.time
                ).uppercase(),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            IconButton(onClick = {
                if (displayedMonth == 11) {
                    displayedMonth = 0
                    displayedYear++
                } else {
                    displayedMonth++
                }
            }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next Month", tint = Color.White)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN").forEach { day ->
                Text(text = day, fontWeight = FontWeight.Bold, color = Color.LightGray)
            }
        }

        val days = (1..daysInMonth).toList()
        val calendar = Calendar.getInstance()

        val totalDays = (daysInMonth + firstDayOfMonth - 1)
        val totalRows = (totalDays / 7) + if (totalDays % 7 != 0) 1 else 0

        Column {
            for (i in 0 until totalRows) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    for (j in 0..6) {
                        val dayIndex = i * 7 + j
                        if (dayIndex < firstDayOfMonth - 1 || dayIndex - (firstDayOfMonth - 1) >= daysInMonth) {
                            Box(modifier = Modifier.size(40.dp))
                        } else {
                            val day = days[dayIndex - (firstDayOfMonth - 1)]
                            calendar.set(displayedYear, displayedMonth, day)
                            val date = calendar.time
                            val isSelected = selectedDate?.let { isSameDay(date, it) } ?: false
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        if (isSelected) Color.Gray else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .clickable {
                                        selectedDate = date
                                        onDateSelected(date)
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = day.toString(), color = Color.LightGray)
                            }
                        }
                    }
                }
            }
        }
    }
}


fun getDaysInMonth(month: Int, year: Int): Int {
    return Calendar.getInstance().apply {
        set(Calendar.MONTH, month)
        set(Calendar.YEAR, year)
        set(Calendar.DAY_OF_MONTH, 1)
        roll(Calendar.DAY_OF_MONTH, -1)
    }.get(Calendar.DAY_OF_MONTH)
}

fun getFirstDayOfMonth(month: Int, year: Int): Int {
    return Calendar.getInstance().apply {
        set(Calendar.MONTH, month)
        set(Calendar.YEAR, year)
        set(Calendar.DAY_OF_MONTH, 1)
    }.get(Calendar.DAY_OF_WEEK).let {
        if (it == Calendar.SUNDAY) 7 else it - 1
    }
}

fun isSameDay(date1: Date, date2: Date): Boolean {
    val calendar1 = Calendar.getInstance().apply { time = date1 }
    val calendar2 = Calendar.getInstance().apply { time = date2 }
    return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
            calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR)
}

fun generateTimeSlots(): List<String> {
    val timeSlots = mutableListOf<String>()
    val startHour = 9
    val endHour = 21

    for (hour in startHour until endHour) {
        val hour12 = if (hour > 12) hour - 12 else hour
        val amPm = if (hour >= 12) "PM" else "AM"
        val hourString = if (hour12 < 10) "0$hour12" else "$hour12"

        timeSlots.add("$hourString:00 $amPm")
        timeSlots.add("$hourString:30 $amPm")
    }
    return timeSlots
}

