package com.example.v01.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.v01.R

class UserDetails : AppCompatActivity() {

    lateinit var logoutBTN : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        setupView()
        setupListener()
    }

    private fun setupView() {
        logoutBTN = findViewById(R.id.LogoutBTN)
    }

    private fun setupListener() {
        logoutBTN.setOnClickListener {
            sharedPreference!!.clearSharedPreference()
            Toast.makeText(this,"User LogOut Successfully.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}