package com.example.giantbombapigroupproject.enum_singleton

import android.content.Context
import android.graphics.Bitmap
import java.io.File
import java.net.URL

object UserLoginStatus {
    private var userApiKey:String?="4aa162f5448bde1772c4778bd8d966811da0124c"
    fun getValue():String?{
        return userApiKey
    }
    fun setValue(value:String){
        UserLoginStatus.userApiKey = value
    }
}

object ApiList{
    private val ApiList = mutableListOf<ApiData>()
    fun add(data:ApiData){
        ApiList.add(data)
    }
    fun get(index:Int):ApiData{
        return ApiList[index]
    }
    fun size():Int{
        return ApiList.size
    }
    fun set(index: Int,data: ApiData){
        ApiList[index] = data
    }
}

data class ApiData(val gameThumbnailLocation:URL?){
    var gameName:String = ""
    var gameDescription:String = ""
    var gameThumbnail:Bitmap? = null
}

data class UserData(val context:Context) {
    val input:File = File(context.filesDir, "loginJSONFile.json")
    var searchTerm: String = "mario"
    var username: String = ""
    var password: String = ""
    var tokenKey: String = ""
    //var profilePicture: Bitmap? = null
    val apiUrl:URL = URL("https://www.giantbomb.com/api/search/?api_key=${UserLoginStatus.getValue()}" +
            "&format=json&query=$searchTerm&resources=game")
    var result: LoginResult = LoginResult.NONE
}
