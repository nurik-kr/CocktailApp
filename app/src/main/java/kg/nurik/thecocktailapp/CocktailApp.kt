package kg.nurik.thecocktailapp

import android.app.Application
import kg.nurik.thecocktailapp.di.injectModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CocktailApp : Application() {

    override fun onCreate() {
        super.onCreate()
//        PrefHelper.init(this)
        startKoin {
            androidContext(this@CocktailApp)
            injectModules()
        }
    }

}