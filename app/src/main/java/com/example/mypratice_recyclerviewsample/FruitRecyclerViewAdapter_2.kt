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
// 改進版的 RecyclerView Adapter - 展示良好的封裝設計
class FruitRecyclerViewAdapter_2(private val fruitList: List<FruitItemDataClass>): RecyclerView.Adapter<FruitRecyclerViewAdapter_2.FruitRecyclerViewHolder2>() {

    inner class FruitRecyclerViewHolder2(private val binding: FruitItemViewBinding): RecyclerView.ViewHolder(binding.root){

        // 將 View 元件改為 private，提升封裝性
        // 原本：val fruitName = binding.tvNameValue (public，外部可直接存取)
        // 現在：private val fruitName = binding.tvNameValue (private，只有內部可存取)
        private val fruitName = binding.tvNameValue
        private val fruitDescription = binding.tvDescriptionValue
        private val fruitPrice = binding.tvPriceValue

        // 新增 bind() 方法，實現職責分離
        // 目的：讓 ViewHolder 負責自己的數據綁定邏輯
        // 好處：Adapter 不需要知道 ViewHolder 內部如何處理數據
        fun bind(item: FruitItemDataClass) {
            fruitName.text = item.name
            fruitDescription.text = item.description
            fruitPrice.text = item.price.toString()

            // 未來擴展點：可以在這裡加入更多邏輯而不影響 Adapter
            // 例如：點擊事件、格式化、條件顯示等
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitRecyclerViewHolder2 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FruitItemViewBinding.inflate(inflater, parent, false)
        return FruitRecyclerViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: FruitRecyclerViewHolder2, position: Int) {
        // 簡化 onBindViewHolder 邏輯
        // 原本：直接操作 holder 的各個 View 元件 (違反封裝)
        // 現在：只需調用 holder.bind() 方法 (符合封裝原則)
        val fruitItem = fruitList[position]
        holder.bind(fruitItem) // 委託給 ViewHolder 處理，職責更清晰
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}