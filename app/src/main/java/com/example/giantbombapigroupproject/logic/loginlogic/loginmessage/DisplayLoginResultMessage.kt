package com.example.giantbombapigroupproject.logic.loginlogic.loginmessage

import android.widget.Toast
import com.example.giantbombapigroupproject.enum_singleton.*

class DisplayLoginResultMessage(userData: UserData) {
    init{
        when (userData.result) {
            LoginResult.SUCCESS -> Toast.makeText(userData.context, LOGIN_SUCCESS, Toast.LENGTH_SHORT).show()
            LoginResult.FAIL -> Toast.makeText(userData.context, LOGIN_FAIL, Toast.LENGTH_SHORT).show()
            LoginResult.JSON_ERROR -> Toast.makeText(userData.context, JSON_ERROR, Toast.LENGTH_SHORT).show()
            LoginResult.USERNAME_ERROR -> Toast.makeText(userData.context, USERNAME_ERROR,Toast.LENGTH_SHORT).show()
            LoginResult.FILE_NOT_FOUND_ERROR-> Toast.makeText(userData.context, FILE_NOT_FOUND_ERROR,Toast.LENGTH_SHORT).show()
            LoginResult.NONE -> Toast.makeText(userData.context, ERROR,Toast.LENGTH_SHORT).show()
        }
    }
}