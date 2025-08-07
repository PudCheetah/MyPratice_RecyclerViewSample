package com.example.mypratice_recyclerviewsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypratice_recyclerviewsample.databinding.FruitItemViewBinding


/*             ////////////////////////////////////////////////
 *             // ******這是改進版的RecyclerViewAdapter*******  //
 *             // 將資料綁定＋互動邏輯封裝在一個 bind()裡面         //
 *             // 使其封裝性更加、職責分離清晰且具更高的可讀性        //
 *             // 可維護性、可拓展性                                  //
 *             //                                            //
 *             ////////////////////////////////////////////////
 */
class FruitRecyclerViewAdapter_2(private val fruitList: List<FruitItemDataClass>): RecyclerView.Adapter<FruitRecyclerViewAdapter_2.FruitRecyclerViewHolder2>() {
    inner class FruitRecyclerViewHolder2(private val binding: FruitItemViewBinding): RecyclerView.ViewHolder(binding.root){
        private val fruitName = binding.tvNameValue
        private val fruitDescription = binding.tvDescriptionValue
        private val fruitPrice = binding.tvPriceValue

        fun bind(item: FruitItemDataClass) {
            fruitName.text = item.name
            fruitDescription.text = item.description
            fruitPrice.text = item.price.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitRecyclerViewHolder2 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FruitItemViewBinding.inflate(inflater, parent, false)
        return FruitRecyclerViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: FruitRecyclerViewHolder2, position: Int) {
        val fruitItem = fruitList[position]
        holder.bind(fruitItem)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}