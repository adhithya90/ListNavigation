package com.example.listapplication.screens

import android.content.ClipData.Item
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.listapplication.model.Items
import com.example.listapplication.model.getItems

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
fun ListWithRow(
    navController: NavController,
    listView: List<Items> = getItems()
) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(items = listView) {
            RowWithCard(item = it) { item ->
                navController.navigate(route = ListScreens.DetailsScreen.name + "/$item")
            }
        }
    }
}


@Composable
fun RowWithCard(
    item: Items,
    onItemClick: (String) -> Unit = {}
) {
    Row(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .height(500.dp)
                .clickable {
                    onItemClick(item.id)
                },
            elevation = 7.dp
        ) {
            Column() {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(item.poster)
                            .apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                                transformations(CircleCropTransformation())
                            }).build()
                    ),
                    contentDescription = "Adhi",
                )
                Text(modifier = Modifier.padding(4.dp), text = item.title)
                Text(text = item.plot)
            }

        }
    }
}