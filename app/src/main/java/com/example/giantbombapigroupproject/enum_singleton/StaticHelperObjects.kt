package com.example.giantbombapigroupproject.enum_singleton

import android.content.Context
import android.graphics.Bitmap
import java.io.File
object UserLoginStatus {
    private var value:String?=null
    fun getValue():String?{
        return value
    }
    fun setValue(value:String){
        UserLoginStatus.value = value
    }
}

data class UserData(val context:Context) {
        val input:File = File(context.filesDir, "loginJSONFile.json")
        var username: String = ""
        var password: String = ""
        var tokenKey: String = ""
        //var profilePicture: Bitmap? = null
        var result: LoginResult = LoginResult.NONE
    }