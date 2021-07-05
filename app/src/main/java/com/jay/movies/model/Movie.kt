package com.jay.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val imageUrl: String,
) : Parcelable