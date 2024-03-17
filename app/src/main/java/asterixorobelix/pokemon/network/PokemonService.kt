package asterixorobelix.pokemon.network

import asterixorobelix.pokemon.POKEMON_ID
import asterixorobelix.pokemon.POKEMON_URL_PREFIX
import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.models.detail.PokemonDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("${POKEMON_URL_PREFIX}/?limit=100")
    suspend fun getPokemon(): Pokemon

    @GET("${POKEMON_URL_PREFIX}/{pokemonId}")
    suspend fun getPokemonById(@Path(POKEMON_ID) pokemonId: Int): PokemonDetail
}