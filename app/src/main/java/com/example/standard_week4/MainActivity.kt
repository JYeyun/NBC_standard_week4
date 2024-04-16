package com.example.standard_week4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val cardList = cardDataList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CardAdapter(cardList)
        binding.cardRecycler.adapter = adapter
        binding.cardRecycler.layoutManager = LinearLayoutManager(this)
    }

}