package com.example.giantbombapigroupproject.feature.loginfeatures.presentercoordinator

import android.app.Activity
import android.content.Intent
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.presenter.LoginScreenActivity
import com.example.giantbombapigroupproject.presenter.NewUserScreenActivity
import com.example.giantbombapigroupproject.presenter.mainactivity.MainActivity

fun Activity.navigate(destination:Activity,userData: UserData) {
    ActivityCoordinator().goToActivity(destination,userData)
}

abstract class BaseActivityCoordinator{
    fun goToActivity(destination: Activity, userData: UserData){
        val goToLogin = Intent(userData.context, destination::class.java)
        userData.context.startActivity(goToLogin)
    }
}

class ActivityCoordinator:BaseActivityCoordinator() {

    fun goToActivity(destination:LoginScreenActivity,userData: UserData){}

    fun goToActivity(destination:MainActivity,userData: UserData){}

    fun goToActivity(destination:NewUserScreenActivity,userData: UserData){}

}
