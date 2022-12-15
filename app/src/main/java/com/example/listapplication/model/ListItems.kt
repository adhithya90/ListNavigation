package com.example.listapplication.model

data class Items(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String
)

fun getItems(): List<Items> {
    return listOf(
        Items(
            "a37437",
            "The Transformation",
            "2023",
            "Self directed",
            "Adhi",
            "Adhi",
            "Will overcome hurdles to get to where he wants to be",
            "https://framerusercontent.com/images/6UDqwj0wLlRAx3X4uzm6TwzQ0MU.jpg"
        )
    )
}
