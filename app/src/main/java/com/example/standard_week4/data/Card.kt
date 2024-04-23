package com.example.standard_week4.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card (
    val name:String,
    val number:String,
    val date:String,
    val money:String
):Parcelable