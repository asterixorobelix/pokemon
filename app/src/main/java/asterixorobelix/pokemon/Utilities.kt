package asterixorobelix.pokemon

const val POKEMON_URL_PREFIX = "pokemon"
const val POKEMON_ID = "pokemonId"

/**
 * index retrieved from the list starts at 0, but api is not zero indexed
 */
fun getAPIIndex(pokemonListIndex: Int?): Int = (pokemonListIndex ?: 0) + 1