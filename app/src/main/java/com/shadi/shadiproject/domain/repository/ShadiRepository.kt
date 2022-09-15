package com.shadi.shadiproject.domain.repository

import com.shadi.shadiproject.data.local.entity.ShadiListEntity
import com.shadi.shadiproject.utils.Resource
import kotlinx.coroutines.flow.Flow


interface ShadiRepository {

    suspend fun getListShadi(
        result: String?
    ): Flow<Resource<List<ShadiListEntity>>>

    suspend fun updateShadiModel(shadiListEntity: ShadiListEntity)
}