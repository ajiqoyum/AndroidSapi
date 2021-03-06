package com.example.v01.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.v01.*
import com.example.v01.API.*
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
    var sharedPreference:SharedPreference? = null

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

        sharedPreference = SharedPreference(this)
        val login_status = sharedPreference!!.getPreferenceString("login_status")
        if (login_status != "1"){
            updatename.setEnabled(false)
            updateberat.setEnabled(false)
            updatejenis.setEnabled(false)
            updatekondisi.setEnabled(false)
            updateumur.setEnabled(false)
            radioJK.setEnabled(false)
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
        //Untuk Hak Akses selain admin hanya dapat mengupdate satu item
        val login_status = sharedPreference!!.getPreferenceString("login_status")
        if (login_status != "1") {
            //init item yang ingin di ubah (catatan) dan inputannya
            var updateworker = updateJson()
            updateworker.id = sapi.id
            updateworker.updateKey = "catatan"
            updateworker.updateValue = updatecatatan.text.toString()
            //API call
            updateBtn.setOnClickListener {
                api.UpdateCttn(updateworker)
                    .enqueue(object : Callback<SubmitModel> {
                        override fun onResponse(
                            call: Call<SubmitModel>,
                            response: Response<SubmitModel>
                        ) {
                            if (response.isSuccessful) {
                                val submit = response.body()
                                Toast.makeText(
                                    applicationContext,
                                    "Catatan Disimpan",
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(
                                    Intent(this@UpdateReal, MainActivity::class.java)
                                )
                            }
                        }

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                            finish()
                        }

                    })
            }
        } else {
            updateBtn.setOnClickListener {
                //init item yang ingin diubah
                var requestJson = RequestRaw()
                requestJson.id = sapi.id
                requestJson.namacow = updatename.text.toString()
                requestJson.jkcow = JK
                requestJson.umur = updateumur.text.toString()
                requestJson.kondisi = updatekondisi.text.toString()
                requestJson.berat = updateberat.text.toString()
                requestJson.jenis = updatejenis.text.toString()
                requestJson.catatan = updatecatatan.text.toString()
                //API call
                api.Update(requestJson)
                    .enqueue(object : Callback<SubmitModel> {
                        override fun onResponse(
                            call: Call<SubmitModel>,
                            response: Response<SubmitModel>
                        ) {
                            if (response.isSuccessful) {
                                val submit = response.body()
                                Toast.makeText(
                                    applicationContext,
                                    "Data berhasil di Update",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                                startActivity(
                                    Intent(this@UpdateReal, MainActivity::class.java)
                                )
                            }
                        }

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                            finish()
                        }

                    })
            }
        }
    }


}