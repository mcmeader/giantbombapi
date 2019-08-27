package com.example.giantbombapigroupproject

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.lang.StringBuilder

enum class LoginResult {
    FAIL,
    SUCCESS,
    ERROR_CHECK_JSON
}

object Token {
    private var value:String?=null
    fun getValue():String?{
        return value
    }
    fun setValue(value:String){
        this.value = value
    }
}

class CheckLoginInfo(fileName:InputStream){
    private var filename:InputStream= fileName
    private var fileText = ""

    init{
        importReadFile()
    }

    private fun importReadFile(){
        filename.bufferedReader().forEachLine {fileText += it }
    }

    private fun checkJSON(username:String,password:String):LoginResult {
        //println(fileText)
        val json = JSONArray(fileText)
        for (i in 0..(json.length()-1)) {
            try{
                if ((json.getJSONObject(i).get("username") == username)
                && (json.getJSONObject(i).get("password") == password)) {
                    Token.setValue(json.getJSONObject(i).get("tokenKey").toString())
                    return LoginResult.SUCCESS
                }
            }catch(e: JSONException){
                return LoginResult.ERROR_CHECK_JSON
            }
        }
        return LoginResult.FAIL
    }

    fun getResults(username:String,password:String):LoginResult {
        return checkJSON(username,password)
    }
}