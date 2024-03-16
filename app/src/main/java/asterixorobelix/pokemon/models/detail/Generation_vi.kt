package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Generation_vi (

  @SerializedName("omegaruby-alphasapphire" ) var omegaruby_alphasapphire : Omegaruby_alphasapphire? = Omegaruby_alphasapphire(),
  @SerializedName("x-y"                     ) var x_y                     : X_y?                     = X_y()

)