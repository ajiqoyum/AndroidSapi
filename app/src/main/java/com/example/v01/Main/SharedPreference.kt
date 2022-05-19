package com.example.v01.Main

import android.content.Context
import android.content.SharedPreferences

class SharedPreference (val context: Context) {
    private val preference_name = "preferenceRCT"
    val shared_Pref: SharedPreferences = context.getSharedPreferences(preference_name, Context.MODE_PRIVATE)

    fun getPreferenceString(key_name: String): String? {
        return shared_Pref.getString(key_name, null)
    }

    fun save_string(key_name: String, text: String){
        val editor: SharedPreferences.Editor = shared_Pref.edit()
        editor.putString(key_name, text)
        editor.commit()
    }

    fun clearSharedPreference() {
        val editor: SharedPreferences.Editor = shared_Pref.edit()
        editor.clear()
        editor.commit()
    }

}