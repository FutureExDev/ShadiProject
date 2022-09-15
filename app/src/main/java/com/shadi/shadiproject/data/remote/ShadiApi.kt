package com.shadi.shadiproject.data.remote

import com.shadi.shadiproject.data.local.model.ShadiListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShadiApi {

    @GET("/api")
    suspend fun getListings(
        @Query("results") result: String
    ): Response<ShadiListModel>
    companion object {
        const val BASE_URL = "https://randomuser.me"
    }

}