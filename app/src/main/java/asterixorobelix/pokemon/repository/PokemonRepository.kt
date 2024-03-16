package asterixorobelix.pokemon.repository

import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.models.detail.PokemonDetail
import asterixorobelix.pokemon.network.PokemonService

/**
 * Obtain Pokemon and their info
 */
class PokemonRepository(private val pokemonService: PokemonService) {

    suspend fun obtainPokemon(): Pokemon {
        return pokemonService.getPokemon()
    }

    /**
     * Obtain information regarding a specific pokemon
     * @param pokemonId
     */
    suspend fun obtainPokemonById(pokemonId: Int): PokemonDetail {
        return pokemonService.getPokemonById(pokemonId)
    }
}