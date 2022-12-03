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
import com.example.listapplication.navigation.ListNavigation
import com.example.listapplication.screens.ListWithRow
import com.example.listapplication.ui.theme.ListApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PageView {
                ListNavigation()
            }
        }
    }
}

@Composable
fun PageView(
    content: @Composable () -> Unit
) {
    ListApplicationTheme() {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListApplicationTheme {
        PageView {
            ListNavigation()
        }
    }
}