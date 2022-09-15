package com.shadi.shadiproject.data.local.dao

import androidx.room.*
import com.shadi.shadiproject.data.local.entity.ShadiListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShadiDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShadiList(
        shadiListEntity: List<ShadiListEntity>
    )

    @Query("select * from shadi_list")
    fun getShadiList(): List<ShadiListEntity>

    @Update
    fun updateShadiModel(shadiListEntity: ShadiListEntity)

    @Query("delete from shadi_list")
    fun deleteData()


}

