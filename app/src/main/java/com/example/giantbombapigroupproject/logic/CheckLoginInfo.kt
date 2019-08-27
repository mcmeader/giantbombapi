package com.example.giantbombapigroupproject.logic

import com.example.giantbombapigroupproject.enum_singleton.LoginResult
import com.example.giantbombapigroupproject.enum_singleton.Token
import org.json.JSONArray
import org.json.JSONException
import java.io.*

class CheckLoginInfo(fileName:InputStream){
    private var filename:InputStream= fileName
    private var fileText = ""

    init{
        importFileData()
    }

    private fun importFileData(){
        filename.bufferedReader().forEachLine {fileText += it }
    }

    private fun compareLoginCredentials(username:String, password:String): LoginResult {
        val json = JSONArray(fileText)
        for (i in 0..(json.length()-1)) {
            try{
                if ((json.getJSONObject(i).get("username") == username)
                && (json.getJSONObject(i).get("password") == password)) {
                    Token.setValue(json.getJSONObject(i).get("tokenKey").toString())
                    return LoginResult.SUCCESS
                }
            }catch(e: JSONException){
                return LoginResult.JSON_ERROR
            }
        }
        return LoginResult.FAIL
    }

    fun getResults(username:String,password:String): LoginResult {
        return compareLoginCredentials(username,password)
    }
}