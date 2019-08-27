package com.example.giantbombapigroupproject.logic

import android.content.Context
import android.widget.Toast
import com.example.giantbombapigroupproject.enum_singleton.LoginResult

class ValidLoginController(result: LoginResult, context: Context) {
    init{
        when (result) {
            LoginResult.SUCCESS -> Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
            LoginResult.FAIL -> Toast.makeText(context, "Login Unsuccessful", Toast.LENGTH_SHORT).show()
            LoginResult.JSON_ERROR -> Toast.makeText(context, "JSON Error", Toast.LENGTH_SHORT).show()
            LoginResult.INPUT_ERROR -> Toast.makeText(context,"Username must be in format email@example.com",Toast.LENGTH_SHORT).show()
        }
    }
}