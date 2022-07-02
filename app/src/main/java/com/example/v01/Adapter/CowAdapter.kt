package com.example.v01.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.v01.API.DataModel
import com.example.v01.R

class CowAdapter (
    val sapi: ArrayList<DataModel.Data>,
    val Listener: OnAdapterListener
        ): RecyclerView.Adapter<CowAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layoutsapi, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sapi[position]
        holder.idsapi.text = data.id
        holder.namasapi.text = data.namacow
        holder.jksapi.text = data.jkcow
        holder.kondisisapi.text = data.kondisi
        holder.aktivitassapi.text = data.liveAct
        holder.locsapi.text = data.liveLoc
        holder.umursapi.text = data.umur
        holder.beratsapi.text = data.berat
        holder.jenissapi.text = data.jenis
        holder.catatansapi.text = data.catatan
        holder.itemView.setOnClickListener {
            Listener.onClick( data )
        }

    }

    override fun getItemCount() = sapi.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val idsapi = view.findViewById<TextView>(R.id.id)
        val namasapi = view.findViewById<TextView>(R.id.namasp)
        val jksapi = view.findViewById<TextView>(R.id.JKcard)
        val kondisisapi = view.findViewById<TextView>(R.id.kondisCard)
        val aktivitassapi = view.findViewById<TextView>(R.id.aktivitasCard)
        val locsapi = view.findViewById<TextView>(R.id.locationCard)
        val umursapi = view.findViewById<TextView>(R.id.umurCard)
        val beratsapi = view.findViewById<TextView>(R.id.beratCard)
        val jenissapi = view.findViewById<TextView>(R.id.jenisCard)
        val catatansapi = view.findViewById<TextView>(R.id.catatanCard)
    }

    fun setData(data: List<DataModel.Data>){
        sapi.clear()
        sapi.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(sapi: DataModel.Data)
    }

}