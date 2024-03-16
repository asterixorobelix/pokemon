package asterixorobelix.pokemon.models.detail

import com.google.gson.annotations.SerializedName


data class Versions (

  @SerializedName("generation-i"    ) var generation_i    : Generation_i?    = Generation_i(),
  @SerializedName("generation-ii"   ) var generation_ii   : Generation_ii?   = Generation_ii(),
  @SerializedName("generation-iii"  ) var generation_iii  : Generation_iii?  = Generation_iii(),
  @SerializedName("generation-iv"   ) var generation_iv   : Generation_iv?   = Generation_iv(),
  @SerializedName("generation-v"    ) var generation_v    : Generation_v?    = Generation_v(),
  @SerializedName("generation-vi"   ) var generation_vi   : Generation_vi?   = Generation_vi(),
  @SerializedName("generation-vii"  ) var generation_vii  : Generation_vii?  = Generation_vii(),
  @SerializedName("generation-viii" ) var generation_viii : Generation_viii? = Generation_viii()

)