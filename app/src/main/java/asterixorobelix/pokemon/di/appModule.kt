package asterixorobelix.pokemon.di

import asterixorobelix.pokemon.FirstFragmentViewModel
import asterixorobelix.pokemon.network.PokemonService
import asterixorobelix.pokemon.repository.PokemonRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonService::class.java)
    }
    single { PokemonRepository(get()) }
    viewModel { FirstFragmentViewModel(get()) }
}