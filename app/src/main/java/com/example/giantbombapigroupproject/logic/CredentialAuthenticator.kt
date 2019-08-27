package com.example.giantbombapigroupproject.logic

import com.example.giantbombapigroupproject.enum_singleton.LoginResult
import com.example.giantbombapigroupproject.enum_singleton.UserLoginStatus
import com.example.giantbombapigroupproject.logic.loginlogic.jsonreadwrite.JSONFile
import org.json.JSONException

class CredentialAuthenticator(private val userData: com.example.giantbombapigroupproject.enum_singleton.UserData) {

    fun checkUsernameFormat(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(userData.username).matches()
    }
    fun compareLoginCredentials(): LoginResult {
        val jsonArray = JSONFile(userData).readFile()
        when (checkUsernameFormat()) {
            false -> return LoginResult.INPUT_ERROR
            true -> for (i in 0..(jsonArray.length() - 1)) {
                try {
                    if ((jsonArray.getJSONObject(i).get("username") == userData.username)
                        && (jsonArray.getJSONObject(i).get("password") == userData.password)
                    ) {
                        UserLoginStatus.setValue(jsonArray.getJSONObject(i).get("tokenKey").toString())
                        return LoginResult.SUCCESS
                    }
                } catch (e: JSONException) {
                    return LoginResult.JSON_ERROR
                }
            }
        }
        return LoginResult.FAIL
    }

}