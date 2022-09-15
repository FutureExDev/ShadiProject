package com.shadi.shadiproject.data.local.model


import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("number")
    val number: String = ""
)