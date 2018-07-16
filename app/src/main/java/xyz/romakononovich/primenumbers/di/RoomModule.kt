package xyz.romakononovich.primenumbers.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import xyz.romakononovich.primenumbers.db.HistoryDB
import xyz.romakononovich.primenumbers.db.RepositoryImpl
import javax.inject.Singleton

/**
 * Created by RomanK on 15.07.18.
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(application: Context): HistoryDB = Room.databaseBuilder(application, HistoryDB::class.java, "history_db").build()


    @Singleton
    @Provides
    fun provideRepository(database: HistoryDB) = RepositoryImpl(database)
}