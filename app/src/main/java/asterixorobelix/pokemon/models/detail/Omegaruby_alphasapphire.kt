package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Omegaruby_alphasapphire (

  @SerializedName("front_default"      ) var frontDefault     : String? = null,
  @SerializedName("front_female"       ) var frontFemale      : String? = null,
  @SerializedName("front_shiny"        ) var frontShiny       : String? = null,
  @SerializedName("front_shiny_female" ) var frontShinyFemale : String? = null

)