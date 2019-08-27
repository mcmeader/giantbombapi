package com.example.giantbombapigroupproject.presenter.mainactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.giantbombapigroupproject.R
import com.example.giantbombapigroupproject.enum_singleton.UserData
import com.example.giantbombapigroupproject.logic.mainactivitylogic.RetrieveData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    private fun startFragment() {
        val fragment = VideoGameDataFragment.newInstance()
        val transaction = MainActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment).commitAllowingStateLoss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            RetrieveData().execute(UserData(this)).get()
            startFragment()
        }
        else{}
    }

}