package com.example.lab3

interface DataInterface {
    fun GetType():Int
    companion object{
        const val USER_TYPE = 1
        const val GROUP_TYPE = 2
    }
}