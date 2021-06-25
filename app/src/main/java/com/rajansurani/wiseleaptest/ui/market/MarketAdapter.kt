package com.rajansurani.wiseleaptest.ui.market

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rajansurani.wiseleaptest.R
import com.rajansurani.wiseleaptest.data.model.Market
import com.rajansurani.wiseleaptest.databinding.ItemMarketBinding
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class MarketAdapter(
    private val markets: List<Market>,
    private val context: Context
) : RecyclerView.Adapter<MarketAdapter.MarketViewHolder>(){

    override fun getItemCount() = markets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MarketViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_market,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        holder.recyclerView.market = markets[position]
        holder.recyclerView.tvChange.text = formatPercentage(markets[position].change_24h)
        holder.recyclerView.tvPrice.text = formatCurrency(markets[position].price)
        holder.recyclerView.tvPrice.text = formatCurrency(markets[position].price)
        holder.recyclerView.tvLastUpdated.text = formatTime(markets[position].time)
        if(markets[position].change_24h >0){
            holder.recyclerView.tvChange.setTextColor(context.resources.getColorStateList(R.color.green))
            holder.recyclerView.ivChange.setImageDrawable(context.resources.getDrawable(R.drawable.ic_up))
            holder.recyclerView.ivChange.imageTintList= context.resources.getColorStateList(R.color.green)
        }else{
            holder.recyclerView.tvChange.setTextColor(context.resources.getColorStateList(R.color.red))
            holder.recyclerView.ivChange.setImageDrawable(context.resources.getDrawable(R.drawable.ic_down))
            holder.recyclerView.ivChange.imageTintList= context.resources.getColorStateList(R.color.red)
        }
    }


    inner class MarketViewHolder(
        val recyclerView: ItemMarketBinding
    ) : RecyclerView.ViewHolder(recyclerView.root)

    private fun formatCurrency(value: Double): String {
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.minimumFractionDigits =2
        format.currency = Currency.getInstance("USD")
        return format.format(value)
    }
    private fun formatPercentage(value: Double): String {
        val format: NumberFormat = NumberFormat.getNumberInstance()
        format.minimumFractionDigits = 2
        return format.format(value) +"%"
    }
    private fun formatTime(value: String): String{
        var format: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
        val date :Date = format.parse(value)
        format = SimpleDateFormat("dd-MM-yyyy hh:mm");
        return format.format(date);
    }

}