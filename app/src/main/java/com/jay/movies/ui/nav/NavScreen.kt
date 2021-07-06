package com.jay.movies.ui.nav

sealed class NavScreen(val route: String) {
    object Home : NavScreen(route = "Home")
    object Detail : NavScreen(route = "Detail")
}