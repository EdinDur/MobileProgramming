package com.example.hawkbarbershop.ui.theme.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hawkbarbershop.HomeDestination
import com.example.hawkbarbershop.HomeScreen
import com.example.hawkbarbershop.LoginDestination
import com.example.hawkbarbershop.LoginScreen
import com.example.hawkbarbershop.MyAccountDestination
import com.example.hawkbarbershop.MyAccountScreen
import com.example.hawkbarbershop.NotificationDestination
import com.example.hawkbarbershop.NotificationScreen
import com.example.hawkbarbershop.RegistrationDestination
import com.example.hawkbarbershop.RegistrationScreen
import com.example.hawkbarbershop.ServiceScreen
import com.example.hawkbarbershop.ServicesAndPriceDestination
import com.example.hawkbarbershop.ServicesAndPriceListScreen
import com.example.hawkbarbershop.ServicesDestination
import com.example.hawkbarbershop.SettingAppointmentScreen
import com.example.hawkbarbershop.SettingAppointmentsDestination
import com.example.hawkbarbershop.SettingsDestination
import com.example.hawkbarbershop.SettingsScreen
import com.example.hawkbarbershop.UserProfileDestination
import com.example.hawkbarbershop.UserProfileScreen

@Composable
fun HawkNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LoginDestination.route) {
        composable(route = LoginDestination.route) {
            LoginScreen(
                navigateToRegister = { navController.navigate(RegistrationDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) }
            )
        }
        composable(route = RegistrationDestination.route) {
            RegistrationScreen(
                navigateToLogin = { navController.navigate(LoginDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) }
            )
        }
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToServices = { navController.navigate(ServicesDestination.route) }
            )
        }
        composable(route = ServicesDestination.route) {
            ServiceScreen(
                navigateToServicesAndPrice = { navController.navigate(ServicesAndPriceDestination.route) }
            )
        }
        composable(route = ServicesAndPriceDestination.route) {
            ServicesAndPriceListScreen(
                navigateToSettingAppointments = { navController.navigate(SettingAppointmentsDestination.route) }
            )
        }
        composable(route = SettingAppointmentsDestination.route) {
            SettingAppointmentScreen()
        }
        composable(route = SettingsDestination.route) {
            SettingsScreen(
                navigateToUserProfile = { navController.navigate(UserProfileDestination.route) },
                navigateToMyAccount = { navController.navigate(MyAccountDestination.route) }
            )
        }
        composable(route = UserProfileDestination.route){
            UserProfileScreen()
        }
        composable(route = MyAccountDestination.route){
            MyAccountScreen()
        }
        composable(route = NotificationDestination.route){
            NotificationScreen()
        }
    }
}

