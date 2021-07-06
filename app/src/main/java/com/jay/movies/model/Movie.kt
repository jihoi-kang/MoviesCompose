package com.jay.movies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val imageUrl: String,
) : Parcelable