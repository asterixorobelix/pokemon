package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Ability (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)