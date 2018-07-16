package xyz.romakononovich.primenumbers

import android.app.Application
import xyz.romakononovich.primenumbers.di.AppComponent
import xyz.romakononovich.primenumbers.di.DaggerAppComponent


/**
 * Created by RomanK on 15.07.18.
 */
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
    }

}