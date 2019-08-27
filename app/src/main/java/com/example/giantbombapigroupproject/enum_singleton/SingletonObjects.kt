package com.example.giantbombapigroupproject.enum_singleton

object Token {
    private var value:String?=null
    fun getValue():String?{
        return value
    }
    fun setValue(value:String){
        Token.value = value
    }
}
