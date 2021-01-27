package dev.kaycee.gif_daily.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TrendingGif.TABLE_NAME )
data class TrendingGif(
    @PrimaryKey
    val id: Int,
    val stringID: String? = null,
    val url: String? = null,
    val rating: String? = null,
    val width: String? = null,
    val height: String? = null
) {
    companion object {
        const val TABLE_NAME = "gif_database"
    }
}
