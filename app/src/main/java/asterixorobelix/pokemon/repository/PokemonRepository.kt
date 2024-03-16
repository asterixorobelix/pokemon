package asterixorobelix.pokemon.repository

import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.network.PokemonService

class PokemonRepository(private val pokemonService: PokemonService) {

    suspend fun obtainPokemon(): Pokemon {
        return pokemonService.getPokemon()
    }
}