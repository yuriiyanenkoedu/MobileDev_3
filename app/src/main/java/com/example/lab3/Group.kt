package com.example.lab3

data class Group(val name: String) : DataInterface {
    override fun GetType(): Int {
        return DataInterface.GROUP_TYPE
    }
}