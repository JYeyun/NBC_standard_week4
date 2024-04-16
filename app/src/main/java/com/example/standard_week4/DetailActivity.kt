package com.example.standard_week4

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.standard_week4.databinding.ActivityDetailBinding

class DetailActivity:AppCompatActivity() {
    private val binding:ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    private val item by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("item", Card::class.java)
        } else {
            intent.getParcelableExtra("item")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)

        binding.editName.text = item?.name
        binding.editNumber.text = item?.number
        binding.editDate.text = item?.date
        binding.editMoney.text = item?.money
    }
}