package dev.kaycee.gif_daily.model

import com.squareup.moshi.Json

data class Pagination(
    @Json(name = "total_count")val totalCount: Int,
    @Json(name = "count")val count: Int,
    @Json(name = "offset")val offset: Int
)
