package com.example.riko2010009.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class Pref(activity: Activity) {

    private var sp: SharedPreferences?= null

    private val login = "login"

    init {

        sp= activity.getSharedPreferences (  "Mypref", Context.MODE_PRIVATE)

    }

    fun setIsLogin(value: Boolean){

        sp!!.edit().putBoolean (login, value).apply()

    }

    fun getIslogin(): Boolean{


return sp!!.getBoolean(login, false)

}
}