package com.example.standard_week4.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }
    private val cardList = cardViewModel.cardLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CardAdapter(cardList)
        binding.cardRecycler.adapter = adapter
        binding.cardRecycler.layoutManager = LinearLayoutManager(this)
        adapter.itemClick = object : CardAdapter.ItemClick{
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle().apply {
                    putParcelable("item", cardList[position])
                }
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

}