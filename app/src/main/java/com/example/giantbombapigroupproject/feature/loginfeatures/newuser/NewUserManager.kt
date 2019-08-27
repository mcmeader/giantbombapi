package com.example.giantbombapigroupproject.feature.loginfeatures.newuser

import com.example.giantbombapigroupproject.enum_singleton.LoginResult
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.loginlogic.jsonreadwrite.JSONFile
import com.example.giantbombapigroupproject.logic.LoginDecisionHandler

class NewUserManager{

    fun begin(userData: UserData){
        JSONFile(userData).writeFile()
        LoginDecisionHandler(userData)
    }
}