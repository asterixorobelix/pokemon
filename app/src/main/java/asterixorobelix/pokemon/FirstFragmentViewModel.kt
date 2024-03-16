package asterixorobelix.pokemon

import androidx.lifecycle.ViewModel
import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.repository.PokemonRepository

class FirstFragmentViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    suspend fun getPokemon(): Pokemon {
        return pokemonRepository.obtainPokemon()
    }
}