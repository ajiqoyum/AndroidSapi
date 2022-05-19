package com.example.v01.WeatherAPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.v01.R

class WeatherAdapter (
    val cuaca: Cuaca.Main
        ): RecyclerView.Adapter<WeatherAdapter.ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder2 (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main, parent, false)
    )

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder2, position: Int) {
        holder.temperatur.text = cuaca.temp.toString()
    }

    override fun getItemCount(): Int {
        return 1
    }

    class ViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
        val temperatur = view.findViewById<TextView>(R.id.temperatur)
    }
    fun setData2(data: Cuaca.Main){
        data
    }
}
