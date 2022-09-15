package com.shadi.shadiproject.data.local.model


import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("age")
    val age: String = "",
    @SerializedName("date")
    val date: String = ""
)