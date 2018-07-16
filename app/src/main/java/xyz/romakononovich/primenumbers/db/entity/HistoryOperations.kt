package xyz.romakononovich.primenumbers.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by RomanK on 15.07.18.
 */
@Entity(tableName = "historyoperations")
data class HistoryOperations(@PrimaryKey(autoGenerate = true) var id: Long? = null,
                             val value: Long)