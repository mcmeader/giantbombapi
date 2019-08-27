package com.example.giantbombapigroupproject.feature.loginfeatures

import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.CredentialAuthenticator
import com.example.giantbombapigroupproject.logic.loginlogic.jsonreadwrite.JSONFile
import com.example.giantbombapigroupproject.logic.LoginDecisionHandler

class LoginManager{

    fun begin(userData: UserData){
        userData.result = CredentialAuthenticator(userData).compareLoginCredentials()
        LoginDecisionHandler(userData)
    }
}