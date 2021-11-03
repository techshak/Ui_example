package com.example.weekthreetask

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using shared preferences to save the last state of the app and check its state on resume
        val appSettingPrefs:SharedPreferences = getSharedPreferences("AppSettingPrefs",0)
        val sharedPrefsEdit:SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn:Boolean= appSettingPrefs.getBoolean("NightMode",false)

        // if else to handle the state saved in shared preferences on restart
        if (isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            findViewById<Switch>(R.id.toggle_mode).text = getString(R.string.light)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            findViewById<Switch>(R.id.toggle_mode).text = getString(R.string.dark)
        }

        // Setting the listener on the switch to switch between Dark and light Modes
        var toggleTheme=findViewById<Switch>(R.id.toggle_mode)
        toggleTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefsEdit.putBoolean("NightMode",true)
                sharedPrefsEdit.apply()
                toggleTheme.text = getString(R.string.light)

            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("NightMode",false)
                sharedPrefsEdit.apply()
                toggleTheme.text = getString(R.string.dark)
            }
        }
    }


}