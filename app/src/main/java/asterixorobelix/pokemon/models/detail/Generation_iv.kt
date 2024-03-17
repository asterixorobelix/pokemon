package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Generation_iv (

  @SerializedName("diamond-pearl"        ) var diamond_pearl        : Diamond_pearl?        = Diamond_pearl(),
  @SerializedName("heartgold-soulsilver" ) var heartgold_soulsilver : Heartgold_soulsilver? = Heartgold_soulsilver(),
  @SerializedName("platinum"             ) var platinum             : Platinum?             = Platinum()

)