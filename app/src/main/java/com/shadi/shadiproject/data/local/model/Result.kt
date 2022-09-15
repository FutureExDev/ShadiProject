package com.shadi.shadiproject.data.local.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("dob")
    val dob: Dob = Dob(),
    @SerializedName("email")
    val email: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("id")
    val id: Id = Id(),
    @SerializedName("location")
    val location: Location = Location(),
    @SerializedName("name")
    val name: Name = Name(),
    @SerializedName("nat")
    val nat: String = "",
    @SerializedName("phone")
    val phone: String = "",
    @SerializedName("picture")
    val picture: Picture = Picture(),
)