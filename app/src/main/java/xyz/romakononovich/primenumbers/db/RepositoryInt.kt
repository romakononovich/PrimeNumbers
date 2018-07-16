package xyz.romakononovich.primenumbers.db

import xyz.romakononovich.primenumbers.db.entity.History
import xyz.romakononovich.primenumbers.db.entity.HistoryOperations

/**
 * Created by RomanK on 15.07.18.
 */
interface RepositoryInt {
    fun getHistory(): List<History>
    fun addHistory(list: List<Long>)
    fun getHistoryOperations(): List<HistoryOperations>
    fun addHistoryOperations(limit: Long)
    fun getPrime(limit: Long): List<Long>
}