package tuztech.kozyrnyituzapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tuztech.kozyrnyituzapp.databinding.ItemBarbershopBinding
import tuztech.kozyrnyituzapp.model.Barbershop

class BarbershopAdapter(private val barbershops: List<Barbershop>) :
    RecyclerView.Adapter<BarbershopAdapter.BarbershopViewHolder>() {

    class BarbershopViewHolder(val binding: ItemBarbershopBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarbershopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBarbershopBinding.inflate(layoutInflater, parent, false)
        return BarbershopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BarbershopViewHolder, position: Int) {
        val barbershop = barbershops[position]
        holder.binding.textViewBarbershopName.text = barbershop.name
        holder.binding.textViewBarbershopAddress.text = barbershop.address
    }

    override fun getItemCount(): Int = barbershops.size
}
