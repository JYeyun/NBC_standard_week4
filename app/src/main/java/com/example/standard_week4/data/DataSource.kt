package com.example.standard_week4.data

class DataSource {
    companion object{
        private var INSTANCE:DataSource?=null
        fun getDataSource():DataSource{
            return synchronized(DataSource::class.java){
                val newInstance = INSTANCE?: DataSource()
                INSTANCE =newInstance
                newInstance
            }
        }
        fun getCardList()= cardDataList()
    }
}