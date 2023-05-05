package com.jorgetranin.businesscard.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jorgetranin.businesscard.data.Card
import com.jorgetranin.businesscard.databinding.ItemCardBinding

class CardAdapter : ListAdapter<Card, CardAdapter.ViewHolder>(DiffCallback())  {

var listenershare: (View) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


   inner class ViewHolder (
       private val binding : ItemCardBinding
           ): RecyclerView.ViewHolder(binding.root){
               fun bind(item: Card){
                   binding.tvNome.text = item.nome
                   binding.tvEmail.text = item.email
                   binding.tvTelefone.text = item.telefone
                   binding.tvNomeEmpresa.text = item.empresa
                   binding.cvItemCard.setCardBackgroundColor(Color.parseColor(item.color))
                   binding.cvItemCard.setOnClickListener {
                       listenershare(it)

                   }
               }
           }


}
class DiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Card, newItem: Card) =
        oldItem.id == newItem.id
}