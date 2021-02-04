package dev.kaycee.gif_daily.data.repository

import dev.kaycee.gif_daily.data.local.dao.GifDao
import dev.kaycee.gif_daily.data.remote.api.ApiService
import dev.kaycee.gif_daily.data.remote.api.TrendingGifApiResponse
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
) : GifRepository {

    override fun getAllTrendingGif(apiKey: String): Flow<Resource<List<TrendingGif>>> {
        return object : NetworkBoundResource<List<TrendingGif>, TrendingGifApiResponse>() {

            override suspend fun saveRemoteData(response: TrendingGifApiResponse) {
                val apiData = response.data
                val listGif = ArrayList<TrendingGif>().toMutableList()
                for (item in apiData) {
                    listGif.add(
                        TrendingGif(
                            stringID = item.id,
                            url = item.image.original.url,
                            width = item.image.original.width,
                            height = item.image.original.height
                        )
                    )
                }
                gifDao.addGifList(listGif)
            }

            override fun fetchLocalDb(): Flow<List<TrendingGif>> {
                return gifDao.getAllTrendingGif()
            }

            override fun shouldFetch(data: List<TrendingGif>): Boolean {
                return true
            }

            override suspend fun fetchFromRemote(): Response<TrendingGifApiResponse> {
                return apiService.getTrendingGif(apiKey)
            }
        }.asFlow()
    }
}
