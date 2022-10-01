package gt.uvg.pokelist

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.repository.PokemonRepository
import java.text.FieldPosition

class VistaPokemoFragment : Fragment() {

    private var pokemonPos = 0
    private val pokemonList = PokemonRepository().getPokemonList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vista_pokemo, container, false)
    }

    fun passData(position: Int){
        pokemonPos = position
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(pokemonPos)
        setData(view)
    }

    private fun setData(view: View) {
        var frontN = view.findViewById<ImageView>(R.id.front_image)
        var backN = view.findViewById<ImageView>(R.id.back_image)
        var fronShiny = view.findViewById<ImageView>(R.id.shinyfront_image)
        var backshiny = view.findViewById<ImageView>(R.id.shinyback_image)

        Picasso.get().load(pokemonList[pokemonPos].imageUrlFront).into(frontN)
        Picasso.get().load(pokemonList[pokemonPos].imageUrlBack).into(backN)
        Picasso.get().load(pokemonList[pokemonPos].imageUrlShinnyFront).into(fronShiny)
        Picasso.get().load(pokemonList[pokemonPos].imageUrlShinnyBack).into(backshiny)
    }
}