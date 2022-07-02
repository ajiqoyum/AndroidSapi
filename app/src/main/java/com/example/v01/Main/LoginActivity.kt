package com.example.v01.Main

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.v01.R

private lateinit var inputname : EditText
private lateinit var inputpass : EditText
private lateinit var loginbtn : Button
var sharedPreference:SharedPreference? = null

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = SharedPreference(this)
        setContentView(R.layout.activity_login)
        setupview()
        setupListener()

        val login_status = sharedPreference!!.getPreferenceString("login_status")
        if (login_status.toString()=="1"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else if (login_status.toString() == "2"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupview() {
        inputname = findViewById(R.id.editusername)
        inputpass = findViewById(R.id.editpassword)
        loginbtn = findViewById(R.id.loginbtn)
    }

    private fun setupListener() {
        loginbtn.setOnClickListener {
            var username1 = inputname.text.toString()
            var password1 = inputpass.text.toString()

            username1 = username1.replace(" ", "")
            password1 = password1.replace(" ","")

            if (username1.equals("")&& password1.equals("")){
                Toast.makeText(applicationContext, "Masukkan Info", Toast.LENGTH_SHORT).show()
            }else{
                val username2 = sharedPreference!!.getPreferenceString("username")
                val password2 = sharedPreference!!.getPreferenceString("password")
            }
             if (username1.equals("admin") && password1.equals("123")) {
                Toast.makeText(applicationContext, "Login Sukses", Toast.LENGTH_SHORT).show()

                sharedPreference!!.save_string("login_status","1")

                startActivity(
                    Intent(this@LoginActivity, MainActivity::class.java)
                )
                finish()
            }else if (username1.equals("worker") && password1.equals("123")){
                Toast.makeText(applicationContext, "Login Sukses", Toast.LENGTH_SHORT).show()

                 sharedPreference!!.save_string("login_status","2")

                startActivity(
                    Intent(this@LoginActivity, MainActivity::class.java)
                )
                finish()
            } else {
                val alertdialog = AlertDialog.Builder(this)
                alertdialog.setMessage("Username atau Password Salah!")
                alertdialog.setNegativeButton("Retry",null)
                alertdialog.show()
            }
        }
    }
}