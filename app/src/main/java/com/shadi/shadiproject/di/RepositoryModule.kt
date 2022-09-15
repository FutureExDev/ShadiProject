package com.shadi.shadiproject.di

import com.shadi.shadiproject.data.ShadiParser
import com.shadi.shadiproject.data.local.DataParser
import com.shadi.shadiproject.data.local.entity.ShadiListEntity
import com.shadi.shadiproject.data.repository.ShadiRepositoryImpl
import com.shadi.shadiproject.domain.repository.ShadiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsShadiListParser(
        shadiParser: ShadiParser
    ): DataParser<ShadiListEntity>

    @Binds
    @Singleton
    abstract fun bindsShadiRepository(
        shadiRepositoryImpl: ShadiRepositoryImpl
    ): ShadiRepository

}