package com.example.flixster

import com.google.gson.annotations.SerializedName

class BestMovie {
    @SerializedName("overview")
    var overview : String? = null

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @SerializedName("poster_path")
    var movieImageUrl: String? = null
}