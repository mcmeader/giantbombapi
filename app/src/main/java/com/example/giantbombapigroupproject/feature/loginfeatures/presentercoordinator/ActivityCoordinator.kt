package com.example.giantbombapigroupproject.feature.loginfeatures.presentercoordinator

import android.app.Activity
import android.content.Intent
import com.example.giantbombapigroupproject.enum_singleton.UserData

class ActivityCoordinator(destination:Activity,userData: UserData){
    init{
        val goToLogin = Intent(userData.context, destination::class.java)
        userData.context.startActivity(goToLogin)
    }
}