package com.example.hawkbarbershop.ui.theme.screen.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hawkbarbershop.ui.theme.Red500

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        "home" to Icons.Filled.Home,
        "services" to Icons.Filled.Face,
        "notifications" to Icons.Filled.MailOutline,
        "settings" to Icons.Filled.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxWidth()
    ) {
        BottomAppBar(
            contentColor = Color.DarkGray,
            containerColor = Color.DarkGray,
            modifier = Modifier.height(48.dp)
        ) {
            items.forEach { (route, icon) ->
                BottomNavigationItem(
                    route = route,
                    icon = icon,
                    isSelected = currentRoute == route,
                    onClick = {
                        navController.navigate(route) {
                            navController.graph.startDestinationRoute?.let { startRoute ->
                                popUpTo(startRoute) {
                                    saveState = false
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
@Composable
fun RowScope.BottomNavigationItem(
    route: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.weight(1f)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = route,
            tint = if (isSelected) Red500 else Color.White
        )
    }
}