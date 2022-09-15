package com.shadi.shadiproject.data.local.model


import com.google.gson.annotations.SerializedName

data class ShadiListModel(
    @SerializedName("results")
    val results: List<Result> = listOf()
)