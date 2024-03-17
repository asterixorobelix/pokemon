package asterixorobelix.pokemon

import androidx.lifecycle.ViewModel
import asterixorobelix.pokemon.models.detail.PokemonDetail
import asterixorobelix.pokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @param pokemonRepository [PokemonRepository]
 */
class SecondFragmentViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    /**
     * @param pokemonListIndex index of the item selected by the user
     */
    fun obtainPokemonDetail(pokemonListIndex: Int?): Flow<PokemonDetail> {
        return flow { emit(pokemonRepository.obtainPokemonById(getAPIIndex(pokemonListIndex))) }
    }
}