package com.example.mvvm_rcv_ayudantia.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_rcv_ayudantia.databinding.LenguagesItemBinding
import com.example.mvvm_rcv_ayudantia.model.Lenguage


class LenguageAdapter : RecyclerView.Adapter<LenguageAdapter.LenguageViewHolder>() {

 lateinit var onItemClickListener: (Lenguage) -> Unit


   var lenguages = mutableListOf<Lenguage>()
    @SuppressLint("NotifyDataSetChanged")

    set(value) {
     field = value
     this.notifyDataSetChanged()
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LenguageViewHolder {

    val binding = LenguagesItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
    return LenguageViewHolder(binding)

   }

   override fun onBindViewHolder(holder: LenguageViewHolder, position: Int) {

    val lenguage: Lenguage = lenguages[position]
    holder.bind(lenguage)

   }

   override fun getItemCount(): Int {
    return lenguages.size
   }


   inner class LenguageViewHolder(private var binding: LenguagesItemBinding):
     RecyclerView.ViewHolder(binding.root){

      fun bind (lenguage: Lenguage){
       binding.txtId.text = lenguage.id.toString()
       binding.txtNombre.text = lenguage.nombre

       binding.root.setOnClickListener{
        onItemClickListener(lenguage)
       }


      }


   }

}