package com.shadi.shadiproject.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shadi_list")
data class ShadiListEntity(
    val firstName: String? = "",
    val lastName: String? = "",
    val age: String? = "",
    val dob: String? = "",
    val pictureUrl: String? = "",
    val city: String? = "",
    val state: String? = "",
    val status: Int? = 0,
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
)
