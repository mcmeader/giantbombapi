package com.example.giantbombapigroupproject.logic

import com.example.giantbombapigroupproject.enum_singleton.LoginResult
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.enum_singleton.UserLoginStatus
import org.json.JSONArray
import org.json.JSONException
import java.io.*

class LoginValidationReader(userData:UserData){
    private val userData=userData
    private var fileText=""

    init{
        importFileData()
    }

    private fun importFileData(){
        userData.input.bufferedReader().forEachLine {fileText += it }
    }

    private fun testUserNameFormat():Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(userData.username).matches()
    }

    private fun compareLoginCredentials(): LoginResult {
        val json = JSONArray(fileText)
        when (testUserNameFormat()) {
            false -> return LoginResult.INPUT_ERROR
            true -> for (i in 0..(json.length() - 1)) {
                try {
                    if ((json.getJSONObject(i).get("username") == userData.username)
                        && (json.getJSONObject(i).get("password") == userData.password)
                    ) {
                        UserLoginStatus.setValue(json.getJSONObject(i).get("tokenKey").toString())
                        return LoginResult.SUCCESS
                    }
                } catch (e: JSONException) {
                    return LoginResult.JSON_ERROR
                }
            }
        }
        return LoginResult.FAIL
    }

    fun getResults(): LoginResult {
        return compareLoginCredentials()
    }
}