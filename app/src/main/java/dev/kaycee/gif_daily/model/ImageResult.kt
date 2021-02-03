package dev.kaycee.gif_daily.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ImageResult(
    @Json(name = "original")
    val original: OriginalGifImage
): Parcelable
