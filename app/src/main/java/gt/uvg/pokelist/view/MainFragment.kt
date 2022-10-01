package gt.uvg.pokelist.view

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.repository.PokemonRepository

class MainFragment: Fragment() {
    private val pokemonList = PokemonRepository().getPokemonList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val recyclerView = view.findViewById<RecyclerView>(R.id.rvpoke)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = PokemonListAdapter(pokemonList)*/


    }
}