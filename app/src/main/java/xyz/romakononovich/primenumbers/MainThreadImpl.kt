package xyz.romakononovich.primenumbers

import android.os.Handler
import android.os.Looper

/**
 * Created by RomanK on 15.07.18.
 */
class MainThreadImpl private constructor() : MainThread {

    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun post(runnable: () -> Unit) {
        handler.post(runnable)
    }

    companion object {

        private var mainThread: MainThread? = null

        val instance: MainThread?
            get() {
                if (mainThread == null) {
                    mainThread = MainThreadImpl()
                }

                return mainThread
            }
    }
}