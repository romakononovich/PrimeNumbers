package xyz.romakononovich.primenumbers

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import kotlinx.android.synthetic.main.activity_main.*
import xyz.romakononovich.primenumbers.App.Companion.appComponent
import xyz.romakononovich.primenumbers.db.RepositoryImpl
import javax.inject.Inject
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import xyz.romakononovich.primenumbers.db.entity.HistoryOperations


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var adapterPrime: RvAdapterPrime
    private lateinit var adapterOperations: RvAdapterOperations


    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var repository: RepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        presenter.initRepo(repository)
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapterPrime = RvAdapterPrime(this@MainActivity)
            adapter = adapterPrime
        }

        rvOperations.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapterOperations = RvAdapterOperations(this@MainActivity)
            adapter = adapterOperations
        }

        button.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                calculate()
            }
        }

        editText.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE && v.text.isNotEmpty()) {
                calculate()
                true
            } else false
        }
        presenter.initialization()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun addInRVOperations(limit: Long) {
        adapterOperations.addInList(limit)
    }

    override fun updateRV(list: List<Long>) {
        adapterPrime.setList(list)
    }

    override fun updateRVOperations(list: List<HistoryOperations>) {
        adapterOperations.setList(list)
    }

    private fun calculate() {
        presenter.calculate(editText.text.toString().toLong())
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }

}
