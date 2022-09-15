package com.shadi.shadiproject.di

import android.app.Application
import androidx.room.Room
import com.shadi.shadiproject.data.local.db.ShadiDatabase
import com.shadi.shadiproject.data.remote.ShadiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideInterCeptor(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideShadiApi(okHttpClient: OkHttpClient): ShadiApi {
        return Retrofit.Builder()
            .baseUrl(ShadiApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShadiApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShadiDatabase(application: Application): ShadiDatabase {
        return Room.databaseBuilder(
            application,
            ShadiDatabase::class.java,
            "shadi_db"
        ).allowMainThreadQueries()
            .build()
    }

}