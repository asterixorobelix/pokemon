package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Generation_v (

  @SerializedName("black-white" ) var black_white : Black_white? = Black_white()

)