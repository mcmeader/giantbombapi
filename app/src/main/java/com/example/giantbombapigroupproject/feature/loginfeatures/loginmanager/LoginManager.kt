package com.example.giantbombapigroupproject.feature.loginfeatures.loginmanager

import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.loginlogic.credentialauthentication.CredentialAuthenticator
import com.example.giantbombapigroupproject.logic.loginlogic.loginmessage.DisplayLoginResultMessage

class LoginManager{

    fun begin(userData: UserData){
        userData.result = CredentialAuthenticator(userData).compareCredentials()
        DisplayLoginResultMessage(userData)
    }
}