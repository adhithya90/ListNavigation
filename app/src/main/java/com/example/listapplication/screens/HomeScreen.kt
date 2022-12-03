package com.example.listapplication.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.listapplication.navigation.ListScreens


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Black) {
            Text(
                text = "List Screen",
                color = Color.White
            )
        }
    }) {
        ListWithRow(navController = navController)
    }
}

@Composable
fun ListWithRow(navController: NavController,
    listView: List<String> = listOf(
        "Name",
        "Adhithya",
        "Ramakumar"
    )
) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(items = listView) {
            RowWithCard(name = it) { item ->
                navController.navigate(route = ListScreens.DetailsScreen.name+"/$item")
            }
        }
    }
}

@Composable
fun RowWithCard(
    name: String,
    onItemClick: (String) -> Unit = {}
) {
    Row(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .height(500.dp)
                .clickable {
                    onItemClick(name)
                },
            elevation = 7.dp
        ) {
            Text(modifier = Modifier.padding(4.dp), text = name)
        }
    }
}