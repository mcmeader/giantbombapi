package com.example.giantbombapigroupproject.feature.loginfeatures.newuser

import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.loginlogic.jsonreadwrite.JSONManager
import com.example.giantbombapigroupproject.logic.loginlogic.loginmessage.DisplayLoginResultMessage

class NewUserManager{

    fun begin(userData: UserData){
        JSONManager(userData).writeFile()
        DisplayLoginResultMessage(userData)
    }
}