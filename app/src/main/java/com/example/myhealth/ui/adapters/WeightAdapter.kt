package com.example.myhealth.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.R
import com.example.myhealth.ui.data.WeightDate

class WeightAdapter(
    private var weightList: List<WeightDate>,
    private val context: Context?
) : RecyclerView.Adapter<WeightAdapter.WeightViewHolder>() {

    inner class WeightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeightViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return WeightViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeightViewHolder, position: Int) {
        val weightDate = weightList[position]
        holder.count.text = "${weightDate.count} кг"
        holder.date.text = weightDate.date
    }

    override fun getItemCount(): Int {
        return weightList.size
    }
}