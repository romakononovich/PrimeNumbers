package xyz.romakononovich.primenumbers

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import xyz.romakononovich.primenumbers.db.RepositoryInt
import java.util.concurrent.Executors

/**
 * Created by RomanK on 15.07.18.
 */
@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private lateinit var repository: RepositoryInt

    private val mainThread = MainThreadImpl.instance

    fun initialization() {
        Executors.newSingleThreadExecutor().execute {
            val historyOperations = repository.getHistoryOperations()
            mainThread?.post {
                viewState.apply {
                    updateRVOperations(historyOperations)
                }
            }
        }
    }

    fun calculate(limit: Long) {
        viewState.showProgressBar()

        Executors.newSingleThreadExecutor().execute {
            val historyList = repository.getHistory()
            if (!historyList.isEmpty() && historyList.last().value >= limit) {
                //take from history
                val temp = ArrayList<Long>()
                historyList.subList(0, historyList.lastIndex).forEach {
                    if (it.value < limit) {
                        temp.add(it.value)
                    }
                }
                repository.addHistoryOperations(limit)
                mainThread?.post {
                    viewState.apply {
                        updateRV(temp)
                        addInRVOperations(limit)
                        hideProgressBar()
                    }

                }
            } else {
                //calculate
                val list = repository.getPrime(limit)
                repository.addHistory(list)
                repository.addHistoryOperations(limit)

                mainThread?.post {
                    viewState.apply {
                        updateRV(list.subList(0, list.lastIndex))
                        addInRVOperations(limit)
                        hideProgressBar()
                    }
                }


            }
        }

    }

    fun initRepo(repo: RepositoryInt) {
        repository = repo
    }

}