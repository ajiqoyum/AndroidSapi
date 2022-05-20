package com.example.v01.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.v01.R

class UserDetails : AppCompatActivity() {

    lateinit var logoutBTN : Button
    lateinit var hakAkses : TextView
    lateinit var uname : TextView
    lateinit var pass : TextView
    var sharedPreference:SharedPreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        setupView()
        setupListener()
    }

    private fun setupView() {
        logoutBTN = findViewById(R.id.LogoutBTN)
        hakAkses = findViewById(R.id.TVakses)
        uname = findViewById(R.id.TVuname)
        pass = findViewById(R.id.TVpass)

        sharedPreference = SharedPreference(this)
        val login_status = sharedPreference!!.getPreferenceString("login_status")

        if (login_status == "1"){
            hakAkses.setText("Admin")
            uname.setText("admin")
            pass.setText("123")
        }
        if (login_status == "2") {
            hakAkses.setText("Monitor")
            uname.setText("worker")
            pass.setText("1234")
        }
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