package asterixorobelix.pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import asterixorobelix.pokemon.SecondFragment.Companion.INDEX_KEY
import asterixorobelix.pokemon.databinding.FragmentFirstBinding
import asterixorobelix.pokemon.models.Results
import coil.compose.SubcomposeAsyncImage
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val firstFragmentViewModel: FirstFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        firstFragmentViewModel.viewModelScope.launch {
            _binding?.composeView?.setContent {
                PokemonLazyVerticalGrid(
                    binding.root,
                    firstFragmentViewModel.uiState.collectAsState(initial = listOf())
                )
            }
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

@Composable
fun PokemonLazyVerticalGrid(view: View, pokemon: State<List<Results>>) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(pokemon.value.size) { index ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .clickable {
                            val bundle = bundleOf(INDEX_KEY to index)
                            findNavController(view).navigate(
                                R.id.action_FirstFragment_to_SecondFragment,
                                bundle
                            )
                        },
                ) {
                    Text(
                        text = pokemon.value[index].name ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp)
                    )
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        loading = { CircularProgressIndicator(modifier = Modifier.fillMaxHeight()) },
                        model = getPokemonImageUrl(index),
                        contentDescription = "Pokemon Image",
                        contentScale = ContentScale.FillHeight
                    )
                }
            }
        }
    )
}

private fun getPokemonImageUrl(pokemonListIndex: Int): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${
        getAPIIndex(
            pokemonListIndex
        )
    }.png"
}
