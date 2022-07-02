package com.example.v01.Main

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.v01.R

class User : AppCompatActivity() {

    var sharedPreference:SharedPreference? = null
    lateinit var username : TextView
    lateinit var detaile : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setupView()
        setupListener()
    }

    private fun setupListener() {
        detaile.setOnClickListener {
            val intent = Intent(this, UserDetails::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish()
            startActivity(intent)
        }
    }

    private fun setupView() {
        username = findViewById(R.id.username)
        detaile = findViewById(R.id.moredtl)

        sharedPreference = SharedPreference(this)
        val login_status = sharedPreference!!.getPreferenceString("login_status")

        if (login_status == "1"){
            username.setText("Admin")
        }
        if (login_status == "2") {
            username.setText("Karyawan")
        }
    }
}