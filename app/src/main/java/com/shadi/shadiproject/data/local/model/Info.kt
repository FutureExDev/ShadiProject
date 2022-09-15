package com.shadi.shadiproject.data.local.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    val page: String = "",
    @SerializedName("results")
    val results:String = "",
    @SerializedName("seed")
    val seed: String = "",
    @SerializedName("version")
    val version: String = ""
)