package com.example.giantbombapigroupproject.presenter.mainactivity

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.mainactivitylogic.RetrieveData

class VideoGameDataFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_videogamedata_list, container, false)
        if (view is RecyclerView){
            view.adapter = MyVideoGameDataRecyclerViewAdapter()
        }
        return view
    }

    companion object {
        fun newInstance(): VideoGameDataFragment {
            return VideoGameDataFragment()
        }
    }
}