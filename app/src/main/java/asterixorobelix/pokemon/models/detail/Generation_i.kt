package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Generation_i (

  @SerializedName("red-blue" ) var red_blue : Red_blue? = Red_blue(),
  @SerializedName("yellow"   ) var yellow   : Yellow?   = Yellow()

)