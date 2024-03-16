package asterixorobelix.pokemon

import androidx.lifecycle.ViewModel
import asterixorobelix.pokemon.repository.PokemonRepository

class SecondFragmentViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    suspend fun obtainPokemonDetail(pokemonListIndex: Int?) {

    }
}