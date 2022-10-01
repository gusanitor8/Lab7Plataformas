package gt.uvg.pokelist.view

import android.graphics.Rect
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.CardViewBinding
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    //inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)
    private lateinit var plistener: onItemClicklister
    interface onItemClicklister{
        fun onItemClick(position: Int)
    }

    fun setOnCliclickListener(listner: onItemClicklister){
        plistener = listner
    }


    class PokemonViewHolder(itemView: View, listener: onItemClicklister): RecyclerView.ViewHolder(itemView){
        //var pokeImage : ImageView
        private lateinit var binding: CardViewBinding

        fun render(pokemon: Pokemon){
            binding.itemTittle.text = pokemon.name
            Picasso.get().load(pokemon.imageUrlFront).into(binding.itemImage)
        }
        init{
            binding = CardViewBinding.bind(itemView)
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
            //pokeImage = itemView.findViewById(R.id.item_image)
            //pokeName = itemView.findViewById(R.id.item_tittle)
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListAdapter.PokemonViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return PokemonViewHolder(v, plistener)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        //holder.pokeName.text = pokemonList[position].name.toString()
        //holder.pokeImage.setImageResource(R.drawable.bulba)
        holder.render(pokemonList[position])
    }

    override fun getItemCount(): Int = pokemonList.size
}