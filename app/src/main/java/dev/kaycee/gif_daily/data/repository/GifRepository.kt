package dev.kaycee.gif_daily.data.repository

import dev.kaycee.gif_daily.data.local.dao.GifDao
import dev.kaycee.gif_daily.data.remote.api.ApiService
import dev.kaycee.gif_daily.model.TrendingGif
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface GifRepository {
    fun getAllTrendingGif(apiKey: String): Flow<Resource<List<TrendingGif>>>
}

class DefaultGifRepository @Inject constructor(
    private val gifDao: GifDao,
    private val apiService: ApiService
): GifRepository {

    override fun getAllTrendingGif(apiKey: String): Flow<Resource<List<TrendingGif>>> {
        return object: NetworkBoundRepository<List<TrendingGif>, List<TrendingGif>>() {

            override suspend fun saveRemoteData(response: List<TrendingGif>) {
                return gifDao.addGifList(response)
            }

            override fun fetchLocalDb(): Flow<List<TrendingGif>> {
                return gifDao.getAllTrendingGif()
            }

            override fun shouldFetch(data: List<TrendingGif>): Boolean {
                return true
            }

            override suspend fun fetchFromRemote(): Response<List<TrendingGif>> {
                return apiService.getTrendingGif(apiKey)
            }

        }.asFlow()
    }
}