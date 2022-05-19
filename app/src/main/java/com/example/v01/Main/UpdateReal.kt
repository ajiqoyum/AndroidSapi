package com.example.v01.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.v01.APIRetrofit
import com.example.v01.DataModel
import com.example.v01.R
import com.example.v01.SubmitModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateReal : AppCompatActivity() {

    private val api by lazy { APIRetrofit().endpoint }
    private val sapi by lazy { intent.getSerializableExtra("sapi") as DataModel.Data }
    private lateinit var updatename: EditText
    private lateinit var updatekondisi: EditText
    private lateinit var updateberat: EditText
    private lateinit var updateumur: EditText
    private lateinit var updatecatatan: EditText
    private lateinit var updateBtn: Button
    private lateinit var updatejenis: EditText
    private lateinit var radioJK: RadioGroup
    private lateinit var setting: Toolbar

    private var JK = "Jantan"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_real)
        setting = findViewById(R.id.toolbarku)
        setSupportActionBar(setting)
        supportActionBar!!.title = "Edit Sapi"
        setupView()
        setupListener()
    }

    private fun setupView() {
        updatename = findViewById(R.id.namaUpdt)
        updatekondisi = findViewById(R.id.kondisiUpdt)
        updateberat = findViewById(R.id.beratUpdt)
        updateumur = findViewById(R.id.umurUpdt)
        updatecatatan = findViewById(R.id.catatanUpdt)
        updateBtn = findViewById(R.id.UpdateRealBtn)
        updatejenis = findViewById(R.id.jenisUpdt)
        radioJK = findViewById(R.id.jkRdoUpdt)
        updatename.setText(sapi.namacow)
        updatekondisi.setText(sapi.kondisi)
        updateberat.setText(sapi.berat)
        updateumur.setText(sapi.umur)
        updatecatatan.setText(sapi.catatan)
        updatejenis.setText(sapi.jenis)
        JK = sapi.jkcow.toString()
        if (JK == "Jantan"){
            radioJK.findViewById<RadioButton>(R.id.jantanRdoUpdt).setChecked(true)
        } else {
            radioJK.findViewById<RadioButton>(R.id.betinaRdoUpdt).setChecked(true)
        }
        radioJK.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.jantanRdoUpdt ->{
                    JK = "Jantan"
                }
                R.id.betinaRdoUpdt ->{
                    JK = "Betina"
                }
            }
        }
    }

    private fun setupListener() {
        updateBtn.setOnClickListener {
            api.update(sapi.id!!, updatename.text.toString(),JK,updateumur.text.toString(),updateberat.text.toString(),updatejenis.text.toString(),updatekondisi.text.toString(),updatecatatan.text.toString())
                .enqueue(object: Callback<SubmitModel> {
                    override fun onResponse(
                        call: Call<SubmitModel>,
                        response: Response<SubmitModel>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext, submit!!.message, Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                        finish()
                    }

                })
        }
    }


}