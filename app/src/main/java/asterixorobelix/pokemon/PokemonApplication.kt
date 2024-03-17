package asterixorobelix.pokemon

import android.app.Application
import asterixorobelix.pokemon.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PokemonApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@PokemonApplication)
            modules(appModule)
        }
    }
}