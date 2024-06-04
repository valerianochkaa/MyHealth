package com.example.myhealth.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.R
import com.example.myhealth.ui.data.WaterDate

class WaterAdapter(
    private var waterList: List<WaterDate>,
    private val context: Context?
) : RecyclerView.Adapter<WaterAdapter.WaterViewHolder>() {

    inner class WaterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return WaterViewHolder(view)
    }

    override fun onBindViewHolder(holder: WaterViewHolder, position: Int) {
        val waterDate = waterList[position]
        holder.count.text = "+ ${waterDate.count} мл"
        holder.date.text = waterDate.date
    }

    override fun getItemCount(): Int {
        return waterList.size
    }
}