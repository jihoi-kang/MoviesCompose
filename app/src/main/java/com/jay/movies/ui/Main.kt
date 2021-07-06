package com.jay.movies.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jay.movies.ui.detail.Detail
import com.jay.movies.ui.home.Home
import com.jay.movies.ui.nav.NavScreen

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            Home(
                selectMovie = {
                    navController.navigate(NavScreen.Detail.route)
                }
            )
        }
        composable(NavScreen.Detail.route) {
            Detail()
        }
    }
}