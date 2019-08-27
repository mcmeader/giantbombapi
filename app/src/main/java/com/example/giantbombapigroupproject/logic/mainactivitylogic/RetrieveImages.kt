package com.example.giantbombapigroupproject.logic.mainactivitylogic

import android.graphics.BitmapFactory
import android.os.AsyncTask
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.ApiList
import com.example.giantbombapigroupproject.presenter.mainactivity.MainActivity
import com.example.giantbombapigroupproject.presenter.mainactivity.VideoGameDataFragment
import java.io.BufferedInputStream

class RetrieveImages {
   fun getPictures(){
        for (i in (0 until ApiList.size())) {
            val apiData = ApiList.get(i)
            val connection = apiData.gameThumbnailLocation?.openConnection()
            val inputStream = BufferedInputStream(connection?.getInputStream())
            apiData.gameThumbnail = BitmapFactory.decodeStream(inputStream)
            ApiList.set(i,apiData)
        }
    }
}