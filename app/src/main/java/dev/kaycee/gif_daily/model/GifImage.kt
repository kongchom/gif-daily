package dev.kaycee.gif_daily.model

import com.squareup.moshi.Json

data class GifImage(
    @Json(name = "original")val original: GifOriginal
)
