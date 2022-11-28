package com.example.listapplication.navigation

enum class ListScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): ListScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }

    }
}