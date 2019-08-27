package com.example.giantbombapigroupproject.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.feature.loginfeatures.presentercoordinator.ActivityCoordinator
import java.util.*
import kotlin.concurrent.schedule

class SplashScreen: AppCompatActivity() {
    private lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        context = this

        //TODO: Clean this up and make conform to presenter coordinator
        Timer("SettingUp", false).schedule(2000) {
            val goToLogin = Intent(context, LoginScreenActivity::class.java)
            startActivity(goToLogin)
        }
    }
}

