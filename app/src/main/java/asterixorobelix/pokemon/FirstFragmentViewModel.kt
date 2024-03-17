package asterixorobelix.pokemon

import androidx.lifecycle.ViewModel
import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.models.Results
import asterixorobelix.pokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class FirstFragmentViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    val uiState: Flow<List<Results>> = flow {
        val pokemon = getPokemon().results
        emit(pokemon)
    }
    private val userSearchText = MutableStateFlow("")
    val searchText = userSearchText.asStateFlow()

    private suspend fun getPokemon(): Pokemon {
        return pokemonRepository.obtainPokemon()
    }

    fun searchPokemonByName(searchText: String) {
        if (searchText.isNotEmpty()) {
            userSearchText.value = searchText
        } else {
            userSearchText.value = ""
        }

    }
}