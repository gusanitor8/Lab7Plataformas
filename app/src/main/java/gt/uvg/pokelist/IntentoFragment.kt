package gt.uvg.pokelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.transaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.repository.PokemonRepository
import gt.uvg.pokelist.view.PokemonListAdapter


class IntentoFragment : Fragment() {

    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction

    private val pokemonList = PokemonRepository().getPokemonList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerView = view.findViewById<RecyclerView>(R.id.rvsipokemonos)
        val layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = layoutManager
        val adapter = PokemonListAdapter(pokemonList)
        recyclerView.adapter = adapter
        adapter.setOnCliclickListener(object : PokemonListAdapter.onItemClicklister{
            override fun onItemClick(position: Int) {
                manager = parentFragmentManager
                transaction = manager.beginTransaction()
                val fra = VistaPokemoFragment()
                fra.passData(position)
                transaction.replace(R.id.frl_recycler,fra)
                transaction.addToBackStack(null)
                transaction.commit()
            }

        })





    }


}