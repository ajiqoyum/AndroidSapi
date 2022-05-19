package com.example.v01.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.v01.MA2.MainActivity2
import com.example.v01.R

private lateinit var inputname : EditText
private lateinit var inputpass : EditText
private lateinit var loginbtn : Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupview()
        setupListener()
    }

    private fun setupview() {
        inputname = findViewById(R.id.editusername)
        inputpass = findViewById(R.id.editpassword)
        loginbtn = findViewById(R.id.loginbtn)
    }

    private fun setupListener() {
        loginbtn.setOnClickListener {
            val username1 = inputname.text.toString()
            val password1 = inputpass.text.toString()

            if (username1.equals("admin") && password1.equals("123")) {
                Toast.makeText(applicationContext, "Login Sukses", Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(this@LoginActivity, MainActivity::class.java)
                )
                finish()
            }else if (username1.equals("worker") && password1.equals("123")){
                Toast.makeText(applicationContext, "Login Sukses", Toast.LENGTH_SHORT).show()

                startActivity(
                    Intent(this@LoginActivity, MainActivity2::class.java)
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