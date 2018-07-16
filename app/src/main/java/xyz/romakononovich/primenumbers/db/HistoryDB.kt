package xyz.romakononovich.primenumbers.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import xyz.romakononovich.primenumbers.db.entity.History
import xyz.romakononovich.primenumbers.db.entity.HistoryOperations

/**
 * Created by RomanK on 15.07.18.
 */
@Database(entities = [History::class, HistoryOperations::class], version = 1)
abstract class HistoryDB : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
    abstract fun historyOperationsDao(): HistoryOperationsDao
}