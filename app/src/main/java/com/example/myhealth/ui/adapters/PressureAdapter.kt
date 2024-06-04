package com.example.myhealth.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.R
import com.example.myhealth.ui.data.PressureDate

class PressureAdapter(
    private var pressureList: List<PressureDate>,
    private val context: Context?
) : RecyclerView.Adapter<PressureAdapter.PressureViewHolder>() {

    inner class PressureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val count: TextView = itemView.findViewById(R.id.count)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PressureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return PressureViewHolder(view)
    }

    override fun onBindViewHolder(holder: PressureViewHolder, position: Int) {
        val pressureDate = pressureList[position]
        holder.count.text = "${pressureDate.upwardPressure} / ${pressureDate.bottomPressure} / ${pressureDate.pulse}"
        holder.date.text = pressureDate.date
    }

    override fun getItemCount(): Int {
        return pressureList.size
    }
}