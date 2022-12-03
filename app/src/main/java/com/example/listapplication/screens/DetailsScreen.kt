package com.example.listapplication.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, listItem: String?) {
    Text(text = listItem.toString())
}