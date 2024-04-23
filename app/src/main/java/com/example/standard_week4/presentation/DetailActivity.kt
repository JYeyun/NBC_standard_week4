package com.example.standard_week4.presentation

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.standard_week4.data.Card
import com.example.standard_week4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding:ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)

        val intent:Intent = getIntent()
        val item = intent.getParcelableExtra<Card>("item")

        binding.editName.text = item?.name
        binding.editNumber.text = item?.number
        binding.editDate.text = item?.date
        binding.editMoney.text = item?.money
    }
}