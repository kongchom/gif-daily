package dev.kaycee.gif_daily.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = TrendingGif.TABLE_NAME )
data class TrendingGif(
    @PrimaryKey
    val id: Int,

    @Json(name = "id")
    @ColumnInfo(name = "stringId")
    val stringID: String?,

    @Json(name = "images")
    val images: List<GifImage>
) {
    companion object {
        const val TABLE_NAME = "gif_database"
    }
}
