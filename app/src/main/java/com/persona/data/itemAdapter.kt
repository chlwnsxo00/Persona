package com.persona.data

import Items
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.persona.persona.Activitys.MenuActivity
import com.persona.persona.R

class itemAdapter(val itemlist:ArrayList<Items>) : RecyclerView.Adapter<itemAdapter.CustomViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item , parent, false)

        return CustomViewHolder(view)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.firstRow.text = itemlist.get(position).firstRow
        holder.time.text = itemlist.get(position).time
        holder.secondRow.text = itemlist.get(position).secondRow
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    class CustomViewHolder(itemview : View): RecyclerView.ViewHolder(itemview) {
        val firstRow = itemView.findViewById<TextView>(R.id.firstRow)
        val time = itemView.findViewById<TextView>(R.id.time)
        val secondRow = itemView.findViewById<TextView>(R.id.secondRow)
    }
}

