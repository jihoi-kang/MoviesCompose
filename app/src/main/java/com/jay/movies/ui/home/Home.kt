package com.jay.movies.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.jay.movies.R
import com.jay.movies.ui.MainViewModel
import com.jay.movies.ui.custom.BaseAppBar
import com.jay.movies.ui.nav.NavScreen

@Composable
fun Home(
    navController: NavController,
    viewModel: MainViewModel,
) {
    val movies = viewModel.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            BaseAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(movies) { movie ->
                MovieItem(movie = movie!!) {
                    navController.navigate("${NavScreen.Detail.route}/${it.id}")
                }
                Divider()
            }
        }
    }
}
