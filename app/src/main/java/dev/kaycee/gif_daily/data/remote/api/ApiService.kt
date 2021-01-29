package dev.kaycee.gif_daily.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service to fetch current trending gif using giphy api
 */
interface ApiService {

    @GET("gifs/trending")
    suspend fun getTrendingGif(@Query("api_key") apiKey: String): Response<TrendingGifApiResponse>

    companion object {
        const val BASE_URL = "https://api.giphy.com/v1/"
        const val API_KEY = "0bAfgbeULLvtxs1olpKPZG9sWYKg1aMT"
    }
}

