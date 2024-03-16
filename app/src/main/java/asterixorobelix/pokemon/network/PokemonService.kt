package asterixorobelix.pokemon.network

import asterixorobelix.pokemon.models.Pokemon
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon/")
    suspend fun getPokemon(): Pokemon
}