package dev.kaycee.gif_daily.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dev.kaycee.gif_daily.model.TrendingGif

object DatabaseMigration {

    const val DB_VERSION = 2

    val MIGRATIONS: Array<Migration>
    get() = arrayOf(migration12())

    private fun migration12(): Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE ${TrendingGif.TABLE_NAME} ADD COLUMN body TEXT")
        }
    }
}
