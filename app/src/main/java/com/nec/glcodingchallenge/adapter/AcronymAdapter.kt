package com.nec.glcodingchallenge.adapter

import com.mutualmobile.gl.data.model.news.acronym.Lfs
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nec.glcodingchallenge.R

class AcronymAdapter (private val list: List<Lfs>, val context: Context) : RecyclerView.Adapter<AcronymAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout_acronym, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position], holder.itemView.context)

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(lfs: Lfs, context: Context) {
            val tvFullForms = itemView.findViewById(R.id.tvFullForms) as TextView
            tvFullForms.text = lfs.lf

        }
    }
}
