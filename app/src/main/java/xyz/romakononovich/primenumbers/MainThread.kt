package xyz.romakononovich.primenumbers

/**
 * Created by RomanK on 15.07.18.
 */
interface MainThread {

    /**
     * Make runnable operation run in the main thread.
     *
     * @param runnable The runnable to run.
     */
    fun post(runnable: () -> Unit)

}