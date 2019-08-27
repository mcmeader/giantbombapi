package com.example.giantbombapigroupproject.logic.loginlogic.jsonreadwrite

import android.util.JsonReader
import android.util.JsonWriter
import com.example.giantbombapigroupproject.enum_singleton.*
import com.example.giantbombapigroupproject.logic.CredentialAuthenticator
import org.json.JSONArray
import org.json.JSONObject
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

class JSONFile(private val userData:UserData) {

    private fun convertToJSONObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("username", userData.username)
        jsonObject.put("password", userData.password)
        jsonObject.put("tokenKey", userData.tokenKey)
        //jsonObject.put("profilePicture", userData.profilePicture)
        return jsonObject
    }
    private fun loadObject(jsonReader: JsonReader): JSONObject {
        jsonReader.beginObject()
        val jsonObject = JSONObject()
        while (jsonReader.hasNext()) {
            jsonObject.put(jsonReader.nextName(), jsonReader.nextString())
        }
        jsonReader.endObject()
        return jsonObject
    }
    private fun unloadObject(jsonWriter: JsonWriter, jsonArray: JSONArray, position: Int) {
        val names = listOf("username", "password", "tokenKey")
        jsonWriter.beginObject()
        for (i in 0..(names.size-1)) {
            jsonWriter.name(names[i])
            jsonWriter.value(jsonArray.getJSONObject(position).getString(names[i]))
        }
        jsonWriter.endObject()
    }

    fun readFile(): JSONArray {
        var jsonObject: JSONObject
        val jsonArray = JSONArray()
        val fileInput:FileInputStream? = FileInputStream(userData.input)
        try {
            val jsonReader = JsonReader(fileInput?.bufferedReader())
            jsonReader.beginArray()
            while (jsonReader.hasNext()) {
                jsonObject = loadObject(jsonReader)
                jsonArray.put(jsonObject)
            }
            jsonReader.endArray()
            jsonReader.close()
        }catch (error : Exception){
            error.stackTrace
        }
        return jsonArray
    }

    fun writeFile() {
            if (CredentialAuthenticator(userData).checkUsernameFormat()) {
                val jsonObject = convertToJSONObject()
                val jsonArray = readFile()
                val fileOutput: FileOutputStream? = FileOutputStream(userData.input)
                val jsonWriter = JsonWriter(fileOutput?.writer())
                jsonArray.put(jsonObject)
                jsonWriter.beginArray()
                for (i in 0..(jsonArray.length() - 1)) {
                    unloadObject(jsonWriter, jsonArray, i)
                }
                jsonWriter.endArray()
                jsonWriter.close()
                LoginResult.SUCCESS
            }else{
                LoginResult.INPUT_ERROR
            }
        }
}
