package com.example.giantbombapigroupproject.model

import android.content.Context
import com.example.giantbombapigroupproject.logic.CheckLoginInfo
import com.example.giantbombapigroupproject.logic.ValidLoginController
import java.io.InputStream

class LoginModel(file:InputStream){
    val file:InputStream = file

    fun loginController(username:String,password:String,context: Context){
        val result = CheckLoginInfo(file).getResults(username,password)
        ValidLoginController(result,context)
    }
}