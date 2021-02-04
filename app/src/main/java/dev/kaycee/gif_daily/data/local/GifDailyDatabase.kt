package dev.kaycee.gif_daily.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.kaycee.gif_daily.data.local.dao.GifDao
import dev.kaycee.gif_daily.model.TrendingGif

@Database(
    entities = [TrendingGif::class],
    version = DatabaseMigration.DB_VERSION
)

abstract class GifDailyDatabase : RoomDatabase() {

    /**
     *For each DAO class that is associated with the database,
     * the database class must define an abstract method
     * that has zero arguments and returns an instance of the DAO class.
     */
    abstract fun getGifDao(): GifDao

    companion object {
        const val DB_NAME = "gif_daily_database"

        @Volatile
        private var INSTANCE: GifDailyDatabase? = null

        fun getInstance(context: Context): GifDailyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GifDailyDatabase::class.java,
                    DB_NAME
                ).addMigrations(*DatabaseMigration.MIGRATIONS).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
