package com.example.giantbombapigroupproject.presenter.mainactivity

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.ApiList

class MyVideoGameDataRecyclerViewAdapter: RecyclerView.Adapter<MyVideoGameDataRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, count: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
            inflate(R.layout.fragment_videogamedata,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (ApiList.size() > 0){
        }else{
            return 0
        }
        return ApiList.size()
    }

    override fun onBindViewHolder(parent: ViewHolder, count: Int) {
        val apiData = ApiList.get(count)
        parent.name.text = apiData.gameName
        parent.description.text = apiData.gameDescription
        parent.image.setImageBitmap(apiData.gameThumbnail)
    }

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val name:TextView = view.findViewById(R.id.title)
        val description:TextView = view.findViewById(R.id.info)
        val image:ImageView = view.findViewById(R.id.thumbnail)
    }
}