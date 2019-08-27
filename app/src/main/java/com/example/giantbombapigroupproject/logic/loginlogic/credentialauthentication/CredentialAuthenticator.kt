package com.example.giantbombapigroupproject.logic.loginlogic.credentialauthentication

import com.example.giantbombapigroupproject.enum_singleton.*
import com.example.giantbombapigroupproject.logic.loginlogic.jsonreadwrite.JSONManager
import org.json.JSONException

class CredentialAuthenticator(private val userData: com.example.giantbombapigroupproject.enum_singleton.UserData) {

    fun checkUsernameFormat(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(userData.username).matches()
    }
    fun compareCredentials(): LoginResult {
        val jsonArray = JSONManager(userData).readFile()
        when (checkUsernameFormat()) {
            false -> return LoginResult.USERNAME_ERROR
            true -> for (i in 0..(jsonArray.length() - 1)) {
                try {
                    if ((jsonArray.getJSONObject(i).get(USERNAME) == userData.username)
                        && (jsonArray.getJSONObject(i).get(PASSWORD) == userData.password)) {
                            UserLoginStatus.setValue(jsonArray.getJSONObject(i).get(TOKENKEY).toString())
                            return LoginResult.SUCCESS
                    }else{ }
                } catch (e: JSONException) {
                    return LoginResult.JSON_ERROR
                }
            }
        }
        return LoginResult.FAIL
    }

}