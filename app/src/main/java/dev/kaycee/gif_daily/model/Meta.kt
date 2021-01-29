package dev.kaycee.gif_daily.model

import com.squareup.moshi.Json

data class Meta(
    @Json(name = "status")val status: Int,
    @Json(name = "msg")val message: String,
    @Json(name = "response_id")val responseId: Int
)
