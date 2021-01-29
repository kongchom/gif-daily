package dev.kaycee.gif_daily.data.remote.api

import com.squareup.moshi.Json
import dev.kaycee.gif_daily.model.Meta
import dev.kaycee.gif_daily.model.Pagination
import dev.kaycee.gif_daily.model.TrendingGif

data class TrendingGifApiResponse(
    @Json(name = "data")val data: List<TrendingGif>,
    @Json(name = "pagination") val pagination: Pagination,
    @Json(name = "meta")val meta: Meta
)