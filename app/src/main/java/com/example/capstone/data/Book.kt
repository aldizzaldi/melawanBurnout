package com.example.capstone.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    var title: String? = null,
    var author: String? = null,
    var genre: String? = null,
    var cover: String? = null
) : Parcelable