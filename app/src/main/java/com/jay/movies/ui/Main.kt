package com.jay.movies.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.jay.movies.ui.detail.Detail
import com.jay.movies.ui.home.Home
import com.jay.movies.ui.nav.NavScreen

@Composable
fun Main(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            Home(
                navController = navController,
                viewModel = viewModel,
            )
        }
        composable(
            NavScreen.Detail.routeWithArgument,
            arguments = listOf(navArgument(NavScreen.Detail.movieId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(NavScreen.Detail.movieId)?.let {
                Detail(
                    navController = navController,
                    movieId = it,
                )
            }
        }
    }
}