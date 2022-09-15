package com.shadi.shadiproject.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shadi.shadiproject.data.local.dao.ShadiDao
import com.shadi.shadiproject.data.local.entity.ShadiListEntity

@Database(entities = [ShadiListEntity::class], version = 1)
abstract class ShadiDatabase : RoomDatabase() {

    abstract fun shadiDao():ShadiDao


}