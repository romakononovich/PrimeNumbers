package xyz.romakononovich.primenumbers.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import xyz.romakononovich.primenumbers.db.entity.HistoryOperations

/**
 * Created by RomanK on 15.07.18.
 */
@Dao
interface HistoryOperationsDao {
    @Query("SELECT * FROM historyoperations")
    fun getHistoryOperations(): List<HistoryOperations>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOperations(historyOperations: HistoryOperations)
}