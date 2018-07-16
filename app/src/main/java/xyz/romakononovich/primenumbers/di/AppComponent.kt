package xyz.romakononovich.primenumbers.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import xyz.romakononovich.primenumbers.MainActivity
import xyz.romakononovich.primenumbers.db.HistoryDB
import javax.inject.Singleton

/**
 * Created by RomanK on 15.07.18.
 */
@Singleton
@Component(modules = [RoomModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun repository(historyDB: HistoryDB)


    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(context: Context): Builder
    }
}