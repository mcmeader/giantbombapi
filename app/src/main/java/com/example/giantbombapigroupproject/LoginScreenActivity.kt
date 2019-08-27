package com.example.giantbombapigroupproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.File

class LoginScreenActivity : AppCompatActivity() {
    lateinit var userName:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_activity)

        val login = findViewById<Button>(R.id.login)
        val loginFile =assets.open("loginJSONFile.txt")
        var checkLogin:CheckLoginInfo = CheckLoginInfo(loginFile)

        login.setOnClickListener {
            userName = findViewById<EditText>(R.id.userName).text.toString()
            password = findViewById<EditText>(R.id.password).text.toString()
            val loginResult = checkLogin.getResults(userName,password)
            when (loginResult){
                LoginResult.SUCCESS -> Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
                LoginResult.FAIL -> Toast.makeText(this,"Login Unsuccessful",Toast.LENGTH_SHORT).show()
                LoginResult.ERROR_CHECK_JSON -> Toast.makeText(this,"JSON Error",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
