package com.example.standard_week4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.standard_week4.data.Card
import com.example.standard_week4.data.DataSource
import com.example.standard_week4.data.cardDataList

class CardViewModel(val dataSource: DataSource): ViewModel() {
    val cardLiveData = cardDataList()
    fun getCardID(id:Long): Card {
        return cardLiveData.get(id.toInt())
    }
}
class CardViewModelFactory: ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass:Class<T>):T{
        if (modelClass.isAssignableFrom(CardViewModel::class.java)){
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}