package dev.kaycee.gif_daily.data.remote.api

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.kaycee.gif_daily.model.Data
import dev.kaycee.gif_daily.model.Meta
import dev.kaycee.gif_daily.model.Pagination
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class TrendingGifApiResponse(
    @Json(name = "data")val data: List<Data>,
    @Json(name = "pagination") val pagination: Pagination,
    @Json(name = "meta")val meta: Meta
): Parcelable