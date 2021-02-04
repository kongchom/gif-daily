package dev.kaycee.gif_daily.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "total_count")val totalCount: Int,
    @Json(name = "count")val count: Int,
    @Json(name = "offset")val offset: Int
) : Parcelable
