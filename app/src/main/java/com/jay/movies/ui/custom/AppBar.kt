package com.jay.movies.ui.custom

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BaseAppBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = { },
) {
    val backgroundColor =
        if (MaterialTheme.colors.isLight) MaterialTheme.colors.primary
        else MaterialTheme.colors.surface
    val contentColor =
        if (MaterialTheme.colors.isLight) MaterialTheme.colors.onPrimary
        else MaterialTheme.colors.onSurface

    TopAppBar(
        navigationIcon = navigationIcon,
        modifier = Modifier.height(56.dp),
        title = title,
        actions = actions,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    )
}

@Composable
fun NavigateIconAppBar(
    title: @Composable () -> Unit,
    imageVector: ImageVector,
    onClickItem: () -> Unit,
    actions: @Composable RowScope.() -> Unit = { },
) {
    val tintColor =
        if (MaterialTheme.colors.isLight) MaterialTheme.colors.onPrimary
        else MaterialTheme.colors.onSurface

    BaseAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = { onClickItem() }) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = "Toolbar Icon",
                    tint = tintColor,
                )
            }
        },
        actions = actions
    )
}