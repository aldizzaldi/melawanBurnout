package com.example.capstone.data

import com.google.firebase.firestore.PropertyName

data class Posts(
        var user: User? = null,
        var title: String? = null,
        var ideas: String? = null,
        @get:PropertyName("image_url") @set:PropertyName("image_url") var imageUrl: String? = null,
        @get:PropertyName("creation_time_ms") @set:PropertyName("creation_time_ms") var creationTimeMs: Long = 0
)