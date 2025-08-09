package com.example.mypratice_recyclerviewsample

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypratice_recyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fruitList = FruitDataSource.fruitList
        binding.rvFruitList.layoutManager = LinearLayoutManager(this)
        binding.rvFruitList.adapter = FruitRecyclerViewAdapter_1(fruitList)
//        binding.rvFruitList.adapter = FruitRecyclerViewAdapter_2(fruitList)

        setContentView(binding.root)
    }
}