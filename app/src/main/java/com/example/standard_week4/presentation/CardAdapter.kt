package com.example.standard_week4.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.standard_week4.data.Card
import com.example.standard_week4.data.cardDataList
import com.example.standard_week4.databinding.BlueItemBinding
import com.example.standard_week4.databinding.OrangeItemBinding
import com.example.standard_week4.databinding.SkyblueItemBinding

class CardAdapter(val cardList:List<Card>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val datas = cardDataList()
    private val ITEM_BLUE = 0
    private val ITEM_SKYBLUE = 1
    private val ITEM_ORANGE = 2

    interface ItemClick{
        fun onItemClick(view:View, position: Int)
    }
    lateinit var itemClick: ItemClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            ITEM_BLUE -> {
                val binding = BlueItemBinding.inflate(inflater, parent, false)
                BlueViewHolder(binding)
            }
            ITEM_SKYBLUE ->{
                val binding = SkyblueItemBinding.inflate(inflater, parent, false)
                SkyblueViewHolder(binding)
            }
            else -> {
                val binding = OrangeItemBinding.inflate(inflater, parent, false)
                OrangeViewHolder(binding)
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> ITEM_BLUE
            1 -> ITEM_SKYBLUE
            else -> ITEM_ORANGE
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder.itemViewType){
            ITEM_BLUE ->{
                val blueHolder = holder as BlueViewHolder
                blueHolder.name.text = cardList[position].name
                blueHolder.number.text = cardList[position].name
                blueHolder.date.text = cardList[position].date
                blueHolder.money.text = cardList[position].money
                holder.itemView.setOnClickListener {
                    itemClick?.onItemClick(it,position)
                }
            }
            ITEM_SKYBLUE ->{
                val SkyblueHolder = holder as SkyblueViewHolder
                SkyblueHolder.name.text = cardList[position].name
                SkyblueHolder.number.text = cardList[position].name
                SkyblueHolder.date.text = cardList[position].date
                SkyblueHolder.money.text = cardList[position].money

                holder.itemView.setOnClickListener {
                    itemClick?.onItemClick(it,position)
                }
            }
            else ->{
                val OrangeHolder = holder as OrangeViewHolder
                OrangeHolder.name.text = cardList[position].name
                OrangeHolder.number.text = cardList[position].name
                OrangeHolder.date.text = cardList[position].date
                OrangeHolder.money.text = cardList[position].money

                holder.itemView.setOnClickListener {
                    itemClick?.onItemClick(it,position)
                }            }
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class BlueViewHolder(private val binding: BlueItemBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.tvName
        val number = binding.tvCardNumber
        val date = binding.tvDate
        val money = binding.tvMoney
    }
    inner class SkyblueViewHolder(private val binding: SkyblueItemBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.tvName
        val number = binding.tvCardNumber
        val date = binding.tvDate
        val money = binding.tvMoney
    }
    inner class OrangeViewHolder(private val binding: OrangeItemBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.tvName
        val number = binding.tvCardNumber
        val date = binding.tvDate
        val money = binding.tvMoney
    }
}