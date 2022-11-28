package com.example.listapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listapplication.ui.theme.ListApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PageView {
                ListWithRow()
            }
        }
    }
}

@Composable
fun ListWithRow(
    listView: List<String> = listOf(
        "Name",
        "Adhithya",
        "Ramakumar"
    )
) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(items = listView) {
            RowWithCard(name = it) { item ->
                Log.d("Clicked inside movie", item)
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

@Composable
fun PageView(
    content: @Composable () -> Unit
) {
    ListApplicationTheme() {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Black) {
                Text(
                    text = "Lol",
                    color = Color.White
                )
            }
        }) {
            content()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListApplicationTheme {
        PageView {
            ListWithRow()
        }
    }
}