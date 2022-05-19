package com.example.v01.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.v01.APIRetrofit
import com.example.v01.R
import com.example.v01.SubmitModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class createInfo : AppCompatActivity() {

    private val api by lazy { APIRetrofit().endpoint }
    private lateinit var editname: EditText
    private lateinit var editkondisi: EditText
    private lateinit var editberat: EditText
    private lateinit var editumur: EditText
    private lateinit var editcatatan: EditText
    private lateinit var simpanBtn: Button
    private lateinit var editjenis: EditText
    private lateinit var radioJK: RadioGroup
    private lateinit var setting: Toolbar
    private var JK = "Jantan"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_info)
        setting = findViewById(R.id.toolbarku)
        setSupportActionBar(setting)
        supportActionBar!!.title = "Tambah Sapi"
        setupView()
        setupListener()
    }

    private fun setupView() {
        editname = findViewById(R.id.namaInp)
        editkondisi = findViewById(R.id.kondisiInp)
        editberat = findViewById(R.id.beratInp)
        editumur = findViewById(R.id.umurInp)
        editcatatan = findViewById(R.id.catatanInp)
        simpanBtn = findViewById(R.id.simpanBtn)
        editjenis = findViewById(R.id.jenisInp)
        radioJK = findViewById(R.id.jkRdo)

        radioJK.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.jantanRdo ->{
                    JK = "Jantan"
                }
                R.id.betinaRdo ->{
                    JK = "Betina"
                }
            }
        }
    }

    private fun setupListener() {
        simpanBtn.setOnClickListener {
            if(editname.text.toString().isNotEmpty()){
                Log.e("createinfo", editname.text.toString())
                api.create(editname.text.toString(),JK,editumur.text.toString(),editberat.text.toString(),editjenis.text.toString(),editkondisi.text.toString(),editcatatan.text.toString())
                    .enqueue(object : Callback<SubmitModel>{
                        override fun onResponse(
                            call: Call<SubmitModel>,
                            response: Response<SubmitModel>
                        ) {
                            if(response.isSuccessful){
                                val submit = response.body()
                                Toast.makeText(applicationContext, submit!!.message, Toast.LENGTH_SHORT).show()
                                finish()
                            }
                        }

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                            finish()
                        }

                    })
            } else {
                Toast.makeText(applicationContext, "Nama Kosong!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}