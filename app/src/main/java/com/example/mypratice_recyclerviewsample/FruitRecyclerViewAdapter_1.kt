package com.example.mypratice_recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypratice_recyclerviewsample.databinding.ActivityMainBinding
import com.example.mypratice_recyclerviewsample.databinding.FruitItemViewBinding


/*
*             //////////////////////////////////////////
*             //     這是基礎版的RecyclerViewAdapter    //
*             //////////////////////////////////////////
**/
class FruitRecyclerViewAdapter_1(private val fruitList: List<FruitItemDataClass>): RecyclerView.Adapter<FruitRecyclerViewAdapter_1.FruitRecyclerViewHolder>(){
    inner class FruitRecyclerViewHolder(private val binding: FruitItemViewBinding): RecyclerView.ViewHolder(binding.root){
        val fruitName = binding.tvNameValue
        val fruitDescription = binding.tvDescriptionValue
        val fruitPrice = binding.tvPriceValue
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FruitItemViewBinding.inflate(inflater, parent, false)
        return FruitRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitRecyclerViewHolder, position: Int) {
        holder.fruitName.text = fruitList[position].name
        holder.fruitDescription.text = fruitList[position].description
        holder.fruitPrice.text = fruitList[position].price.toString()
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}