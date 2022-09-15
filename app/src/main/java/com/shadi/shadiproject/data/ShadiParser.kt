package com.shadi.shadiproject.data

import com.shadi.shadiproject.data.local.DataParser
import com.shadi.shadiproject.data.local.entity.ShadiListEntity
import com.shadi.shadiproject.data.local.model.ShadiListModel
import com.shadi.shadiproject.retantions.ShadiStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShadiParser @Inject constructor() : DataParser<ShadiListEntity> {
    override suspend fun parse(shadiModelList: ShadiListModel): List<ShadiListEntity> {

        val shadiListEntityList = ArrayList<ShadiListEntity>()

        shadiModelList.results.forEach { shadiModel ->
            shadiListEntityList.add(
                ShadiListEntity(
                    shadiModel.name.first,
                    shadiModel.name.last,
                    shadiModel.dob.age,
                    shadiModel.dob.date,
                    shadiModel.picture.large,
                    shadiModel.location.city,
                    shadiModel.location.state,
                    ShadiStatus.DEFAULT.type
                )
            )
        }
        return shadiListEntityList
    }
}