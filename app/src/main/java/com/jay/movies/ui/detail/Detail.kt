package com.jay.movies.ui.detail

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.jay.movies.R
import com.jay.movies.ui.layout.NavigateIconAppBar

@Composable
fun Detail(
    navController: NavController
) {
    Scaffold(
        topBar = {
            DetailAppBar(
                onClickBack = { navController.navigateUp() }
            )
        }
    ) {
        Text(text = "Hello Detail")
    }
}

@Composable
fun DetailAppBar(onClickBack: () -> Unit) {
    NavigateIconAppBar(
        title = { Text(text = stringResource(id = R.string.text_details)) },
        imageVector = Icons.Filled.ArrowBack,
        onClickItem = onClickBack
    )
}