package com.example.hawkbarbershop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.hawkbarbershop.HomeScreen
import com.example.hawkbarbershop.LoginScreen
import com.example.hawkbarbershop.RegistrationScreen
import com.example.hawkbarbershop.ServiceScreen
import com.example.hawkbarbershop.ServicesAndPriceListScreen
import com.example.hawkbarbershop.SettingAppointmentScreen
import com.example.hawkbarbershop.SettingsScreen
import com.example.hawkbarbershop.UserProfileScreen


private val DarkColorPalette = darkColorScheme(
    primary = Color.White,
    secondary = Color.White
)

private val LightColorPalette = lightColorScheme(
    primary = Color.White,
    secondary = Color.White
)

private val AppTypography = Typography()
private val AppShapes = Shapes()

@Composable
fun HawkBarbershopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}


