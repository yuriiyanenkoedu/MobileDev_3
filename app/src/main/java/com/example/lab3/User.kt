package com.example.lab3

data class User(var name:String, var group : String) : DataInterface {
    override fun GetType(): Int {
        return DataInterface.USER_TYPE
    }
}