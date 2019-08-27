package com.example.giantbombapigroupproject.presenter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.feature.loginfeatures.LoginManager
import com.example.giantbombapigroupproject.feature.loginfeatures.presentercoordinator.ActivityCoordinator

class LoginScreenActivity : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_activity)
        val login = findViewById<Button>(R.id.login)
        val newUser = findViewById<Button>(R.id.newUser)
        context = this
        var loginModel: LoginManager

        login.setOnClickListener {
            val(username,password) = Pair(findViewById<EditText>(R.id.userName).text.toString(),
                    findViewById<EditText>(R.id.password).text.toString())
            val passData = UserData(this)
            passData.username=username
            passData.password=password
            loginModel = LoginManager()
            loginModel.begin(passData)
            }
        newUser.setOnClickListener {
            ActivityCoordinator(NewUserScreenActivity(), UserData(this))
        }

        }
    }
