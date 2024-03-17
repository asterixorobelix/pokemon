package asterixorobelix.pokemon.network

import asterixorobelix.pokemon.models.Pokemon
import asterixorobelix.pokemon.models.detail.PokemonDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/")
    suspend fun getPokemon(): Pokemon

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonById(@Path("pokemonId") pokemonId: Int): PokemonDetail
}