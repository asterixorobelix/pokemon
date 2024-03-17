package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Generation_iii (

  @SerializedName("emerald"           ) var emerald           : Emerald?           = Emerald(),
  @SerializedName("firered-leafgreen" ) var firered_leafgreen : Firered_leafgreen? = Firered_leafgreen(),
  @SerializedName("ruby-sapphire"     ) var ruby_sapphire     : Ruby_sapphire?     = Ruby_sapphire()

)