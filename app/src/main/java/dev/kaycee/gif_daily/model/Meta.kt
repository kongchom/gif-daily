package dev.kaycee.gif_daily.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "status")val status: Int,
    @Json(name = "msg")val message: String,
    @Json(name = "response_id")val responseId: String
): Parcelable
