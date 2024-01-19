package com.gmail.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OstAdapter(private val ostlist:List<Post>):RecyclerView.Adapter<OstAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val ostid:TextView = view.findViewById(R.id.textView)
        val osttitle:TextView = view.findViewById(R.id.textView2)
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.osttemp,null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ostlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val o = ostlist[position]
        holder.ostid.text = o.id.toString()
        holder.osttitle.text = o.title
    }
}