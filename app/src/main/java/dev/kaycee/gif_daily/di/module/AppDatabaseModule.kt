package dev.kaycee.gif_daily.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kaycee.gif_daily.data.local.GifDailyDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = GifDailyDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideGifDao(database: GifDailyDatabase) = database.getGifDao()
}