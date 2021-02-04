package dev.kaycee.gif_daily.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GifOriginal(
    @Json(name = "height")val height: Int,
    @Json(name = "width")val width: Int,
    @Json(name = "url")val url: String
)
