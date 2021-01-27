package dev.kaycee.gif_daily.data.remote.api

import dev.kaycee.gif_daily.model.TrendingGif
import retrofit2.Response
import retrofit2.http.GET

/**
 * Service to fetch current trending gif using giphy api
 */
interface ApiService {

    @GET("/$API_KEY")
    fun getTrendingGif(): Response<List<TrendingGif>>

    companion object {
        const val BASE_URL = "api.giphy.com/v1/"
        const val API_KEY = "0bAfgbeULLvtxs1olpKPZG9sWYKg1aMT"
    }
}

