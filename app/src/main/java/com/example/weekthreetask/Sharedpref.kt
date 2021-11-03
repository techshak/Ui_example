package com.example.weekthreetask

import android.content.Context
import android.content.SharedPreferences

class Sharedpref (context: Context){
 lateinit var mySharedpref: SharedPreferences
 init {
     mySharedpref=context.getSharedPreferences("filename",Context.MODE_PRIVATE)
 }
    fun setNightModeState (state:Boolean?){
      val editor:SharedPreferences.Editor= mySharedpref.edit()
        editor.putBoolean("Night Mode", state!!)
        editor.commit()
    }

    fun loadNightModeState():Boolean?{
        return mySharedpref.getBoolean("Night Mode", false)
    }
}
