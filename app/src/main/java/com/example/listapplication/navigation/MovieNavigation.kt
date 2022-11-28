package com.example.listapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ListNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListScreens.HomeScreen.name
    ) {
        composable(ListScreens.HomeScreen.name) {
//            HomeScreen()
        }
    }
}