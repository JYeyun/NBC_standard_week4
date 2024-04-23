package com.example.standard_week4.data

import com.example.standard_week4.data.Card

fun cardDataList():List<Card>{
    return listOf(
        Card(
            "Jung Ye Youn","1234  1234  1234  1234","12 / 26","$3,102.10"
        ),
        Card(
            "Jung Ye Youn", "5678  5678  5678  5678", "07 / 25", "$22,345.66"
        ),
        Card(
            "Jung Ye Youn", "6543  6543  6543  6543", "02 / 28", "$3,100.40"
        )
    )
}