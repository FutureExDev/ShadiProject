package com.shadi.shadiproject.data.repository

import com.shadi.shadiproject.data.local.DataParser
import com.shadi.shadiproject.data.local.db.ShadiDatabase
import com.shadi.shadiproject.data.local.entity.ShadiListEntity
import com.shadi.shadiproject.data.remote.ShadiApi
import com.shadi.shadiproject.domain.repository.ShadiRepository
import com.shadi.shadiproject.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShadiRepositoryImpl @Inject constructor(
    private val api: ShadiApi,
    private val db: ShadiDatabase,
    private val shadiParser: DataParser<ShadiListEntity>
) : ShadiRepository {

    private val shadiDao = db.shadiDao()
    override suspend fun getListShadi(result: String?): Flow<Resource<List<ShadiListEntity>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

            var getLocalDataList = shadiDao.getShadiList()
            if (getLocalDataList.isEmpty().not()) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Success(data = getLocalDataList))
            } else {
                if (result.isNullOrEmpty()) {
                    emit(Resource.Loading(isLoading = false))
                    return@flow
                }
                val remoteList = try {
                    val response = api.getListings(result)
                    response.body()?.let { shadiParser.parse(it) }
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error("can't load data"))
                    null
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error("can't load data"))
                    null
                }
                emit(Resource.Loading(isLoading = false))
                remoteList?.let { datalist ->
                    shadiDao.insertShadiList(datalist)
                }
                 getLocalDataList = shadiDao.getShadiList()
                emit(Resource.Success(data = getLocalDataList))
            }
        }
    }

    override suspend fun updateShadiModel(shadiListEntity: ShadiListEntity) {
        shadiDao.updateShadiModel(shadiListEntity)
    }

}