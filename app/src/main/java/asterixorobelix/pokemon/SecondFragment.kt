package asterixorobelix.pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import asterixorobelix.pokemon.databinding.FragmentSecondBinding
import asterixorobelix.pokemon.models.detail.PokemonDetail
import coil.compose.SubcomposeAsyncImage
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val secondFragmentViewModel: SecondFragmentViewModel by viewModel()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonIndex = arguments?.getInt(INDEX_KEY)



        binding.detailLayout.setContent {
            PokemonDetailUI(
                secondFragmentViewModel.obtainPokemonDetail(pokemonIndex).collectAsState(
                    initial = PokemonDetail(name = "Loading")
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val INDEX_KEY = "index"
    }
}

@Composable
fun PokemonDetailUI(pokemonDetail: State<PokemonDetail>) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Text(
            text = "${pokemonDetail.value.name}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally)
        )
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            loading = { CircularProgressIndicator(modifier = Modifier.fillMaxHeight()) },
            model = pokemonDetail.value.sprites?.frontDefault,
            contentDescription = pokemonDetail.value.name,
            contentScale = ContentScale.FillHeight
        )

        Text(
            text = "Base Experience: ${pokemonDetail.value.baseExperience}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally)
        )
    }
}