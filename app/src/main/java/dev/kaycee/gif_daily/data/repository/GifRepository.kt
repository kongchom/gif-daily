package dev.kaycee.gif_daily.data.repository

import dev.kaycee.gif_daily.data.local.dao.GifDao
import dev.kaycee.gif_daily.data.remote.api.ApiService
import dev.kaycee.gif_daily.model.TrendingGif
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GifRepository {
    fun getAllTrendingGif(): Flow<Resource<List<TrendingGif>>>
}

class DefaultGifRepository @Inject constructor(
    private val gifDao: GifDao,
    private val apiService: ApiService
): GifRepository {
    override fun getAllTrendingGif(): Flow<Resource<List<TrendingGif>>> {

    }
}