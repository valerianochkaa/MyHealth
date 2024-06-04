package com.example.myhealth.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.R
import com.example.myhealth.ui.data.TemperatureDate

class TemperatureAdapter(
    private var temperatureList: List<TemperatureDate>,
    private val context: Context?
) : RecyclerView.Adapter<TemperatureAdapter.TemperatureViewHolder>() {

    inner class TemperatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return TemperatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: TemperatureViewHolder, position: Int) {
        val temperatureDate = temperatureList[position]
        holder.count.text = "${temperatureDate.count}°С"
        holder.date.text = temperatureDate.date
    }

    override fun getItemCount(): Int {
        return temperatureList.size
    }
}