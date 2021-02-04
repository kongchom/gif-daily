package dev.kaycee.gif_daily.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "id")
    val id: String,
    @Json(name = "images")
    val image: ImageResult
): Parcelable
