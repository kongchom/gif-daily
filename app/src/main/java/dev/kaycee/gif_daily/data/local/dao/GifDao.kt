package dev.kaycee.gif_daily.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.kaycee.gif_daily.model.TrendingGif
import kotlinx.coroutines.flow.Flow

@Dao
interface GifDao {

    @Query("SELECT * FROM gif_database")
    fun getAllTrendingGif(): Flow<List<TrendingGif>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGifList(trendingGif: List<TrendingGif>)
}
