package asterixorobelix.pokemon

import androidx.lifecycle.ViewModel
import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.models.Results
import asterixorobelix.pokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FirstFragmentViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    val uiState : Flow<List<Results>> = flow {
        emit(getPokemon().results)
    }

    private suspend fun getPokemon(): Pokemon {
        return pokemonRepository.obtainPokemon()
    }
}