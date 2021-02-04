package dev.kaycee.gif_daily.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TrendingGif.TABLE_NAME )
data class TrendingGif(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "stringId")
    val stringID: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "width")
    val width: Int,

    @ColumnInfo(name = "height")
    val height: Int
) {
    companion object {
        const val TABLE_NAME = "gif_database"
    }
}
