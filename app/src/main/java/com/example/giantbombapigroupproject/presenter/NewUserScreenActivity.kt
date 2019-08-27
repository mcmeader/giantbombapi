package com.example.giantbombapigroupproject.presenter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.feature.loginfeatures.newuser.NewUserManager

class NewUserScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_user_signup_activity)
        val saveUser = findViewById<Button>(R.id.createUser)
        var newUserModel: NewUserManager

        saveUser.setOnClickListener {
            val passData = UserData(this)
            val (username,password) = Pair( findViewById<EditText>(R.id.newUser).text.toString(),
                findViewById<EditText>(R.id.newPassword).text.toString())
            passData.username=username
            passData.password=password

            newUserModel = NewUserManager()
            newUserModel.begin(passData)
        }
    }
}
