package com.example.giantbombapigroupproject.model

import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.LoginValidationReader
import com.example.giantbombapigroupproject.logic.LoginDecisionHandler

class LoginManager{

    fun begin(userData: UserData){
        userData.result = LoginValidationReader(userData).getResults()
        LoginDecisionHandler(userData)
    }
}