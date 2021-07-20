package com.jay.movies.ui.nav

sealed class NavScreen(val route: String) {
    object Home : NavScreen(route = "home")
    object Detail : NavScreen(route = "movies") {
        const val routeWithArgument: String = "movies/{movieId}"
        const val movieId: String = "movieId"
    }
}