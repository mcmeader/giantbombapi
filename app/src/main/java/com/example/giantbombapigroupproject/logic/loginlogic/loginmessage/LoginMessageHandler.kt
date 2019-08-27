package com.example.giantbombapigroupproject.logic.loginlogic.loginmessage

import android.widget.Toast
import com.example.giantbombapigroupproject.enum_singleton.LoginResult
import com.example.giantbombapigroupproject.enum_singleton.UserData

class LoginMessageHandler(userData: UserData) {
    init{
        when (userData.result) {
            LoginResult.SUCCESS -> Toast.makeText(userData.context, "Login Successful", Toast.LENGTH_SHORT).show()
            LoginResult.FAIL -> Toast.makeText(userData.context, "Login Unsuccessful", Toast.LENGTH_SHORT).show()
            LoginResult.JSON_ERROR -> Toast.makeText(userData.context, "JSON Error", Toast.LENGTH_SHORT).show()
            LoginResult.INPUT_ERROR -> Toast.makeText(userData.context,"Username must be in format email@example.com",Toast.LENGTH_SHORT).show()
            LoginResult.FILE_NOT_FOUND_ERROR-> Toast.makeText(userData.context,"File location not found",Toast.LENGTH_SHORT).show()
            LoginResult.NONE -> Toast.makeText(userData.context,"An Error Occurred.  Please contact Tech Support",Toast.LENGTH_SHORT).show()
        }
    }
}