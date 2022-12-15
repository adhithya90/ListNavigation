package com.example.listapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listapplication.screens.DetailsScreen
import com.example.listapplication.screens.HomeScreen

@Composable
fun ListNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListScreens.HomeScreen.name
    ) {
        composable(ListScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        //www.list.com/list-screen/id=23
        composable(
            ListScreens.DetailsScreen.name + "/{listItem}",
            arguments = listOf(navArgument(name = "listItem") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("listItem")
            )
        }
    }
}