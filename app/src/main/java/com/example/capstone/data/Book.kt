package com.example.capstone.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book (
    var title: String,
    var author: String,
    var genre: String
) : Parcelable