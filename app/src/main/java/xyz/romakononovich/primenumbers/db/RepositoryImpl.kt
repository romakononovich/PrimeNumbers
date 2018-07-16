package xyz.romakononovich.primenumbers.db

import xyz.romakononovich.primenumbers.db.entity.History
import xyz.romakononovich.primenumbers.db.entity.HistoryOperations

/**
 * Created by RomanK on 15.07.18.
 */
class RepositoryImpl(private val historyDao: HistoryDB) : RepositoryInt {
    override fun getHistoryOperations(): List<HistoryOperations> {
        return historyDao.historyOperationsDao().getHistoryOperations()
    }

    override fun addHistoryOperations(limit: Long) {
        return historyDao.historyOperationsDao().insertOperations(HistoryOperations(value = limit))
    }

    override fun getHistory(): List<History> {
        return historyDao.historyDao().getHistory()
    }

    override fun addHistory(list: List<Long>) {
        historyDao.clearAllTables()
        list.forEach {
            historyDao.historyDao().insert(History(value = it))
        }
    }

    override fun getPrime(limit: Long): List<Long> {
        val array = ArrayList<Long>()
        var flag = false
        for (i in 2 until limit) {
            flag = false
            for (j in 2..i / 2) {
                if (i.rem(j) == 0L) {
                    flag = true
                    break
                }
            }
            if (!flag) array.add(i) else continue
        }
        array.add(limit) //Marker calculated limit
        return array
    }
}