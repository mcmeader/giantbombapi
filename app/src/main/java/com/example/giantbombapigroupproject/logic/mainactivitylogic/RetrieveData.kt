package com.example.giantbombapigroupproject.logic.mainactivitylogic

import android.os.AsyncTask
import com.example.giantbombapigroupproject.enum_singleton.*
import org.json.JSONException
import org.json.JSONObject
import java.net.URL

class RetrieveData: AsyncTask<UserData, Unit, Unit>() {

    private fun filterData(string: String?) {
        try {
            val jsonObject = JSONObject(string)
            val results = jsonObject.getJSONArray(RESULTS)
            for (i in (0 until results.length())) {
                val apiData = ApiData(URL(results.getJSONObject(i).getJSONObject(ICON).getString(ICON_URL)))
                apiData.gameName = results.getJSONObject(i).getString(NAME)
                apiData.gameDescription = results.getJSONObject(i).getString(DESCRIPTION)
                ApiList.add(apiData)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    override fun doInBackground(vararg userData: UserData?) {
        val connection = userData[0]?.apiUrl?.openConnection()
        val reader = connection?.getInputStream()?.bufferedReader()
        filterData(reader?.readLine())
        RetrieveImages().getPictures()
    }
}