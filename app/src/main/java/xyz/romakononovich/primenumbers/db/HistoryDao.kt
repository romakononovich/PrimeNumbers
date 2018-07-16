package xyz.romakononovich.primenumbers.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import xyz.romakononovich.primenumbers.db.entity.History

/**
 * Created by RomanK on 15.07.18.
 */
@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    fun getHistory(): List<History>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(history: History)
}