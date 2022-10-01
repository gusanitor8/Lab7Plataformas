package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.IntentoFragment
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ActivityMainBinding
import gt.uvg.pokelist.repository.PokemonRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>? = null
    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        transaction.replace(R.id.frl_recycler,IntentoFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val m = menuInflater
        m.inflate(R.menu.item_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.flecha_icono -> {
                manager = supportFragmentManager
                transaction = manager.beginTransaction()
                transaction.replace(R.id.frl_recycler,IntentoFragment())
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}