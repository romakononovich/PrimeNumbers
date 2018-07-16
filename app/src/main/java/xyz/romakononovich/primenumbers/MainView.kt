package xyz.romakononovich.primenumbers

import com.arellomobile.mvp.MvpView
import xyz.romakononovich.primenumbers.db.entity.HistoryOperations

/**
 * Created by RomanK on 15.07.18.
 */
interface MainView : MvpView {
    fun updateRV(list: List<Long>)
    fun updateRVOperations(list: List<HistoryOperations>)
    fun addInRVOperations(limit: Long)
    fun showProgressBar()
    fun hideProgressBar()
}