package com.example.v01.Main

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.v01.*
import com.example.v01.API.APIRetrofit
import com.example.v01.API.DataModel
import com.example.v01.API.SubmitModel
import com.example.v01.API.deleteJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewInfo : AppCompatActivity() {

    private val sapi by lazy { intent.getSerializableExtra("sapi") as DataModel.Data }
    private val api by lazy { APIRetrofit().endpoint }
    private lateinit var tvid: TextView
    private lateinit var tvnama: TextView
    private lateinit var tvumur: TextView
    private lateinit var tvjk: TextView
    private lateinit var tvberat: TextView
    private lateinit var tvjenis: TextView
    private lateinit var tvkondisi: TextView
    private lateinit var tvcatatan: TextView
    private lateinit var tvliveact: TextView
    private lateinit var tvliveloc: TextView
    private lateinit var updatebtn: Button
    private lateinit var deletebtn: ImageView
    private lateinit var setting: Toolbar
    var sharedPreference:SharedPreference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_info)
        setting = findViewById(R.id.toolbarku)
        setSupportActionBar(setting)
        supportActionBar!!.title = "Info Sapi"
        setupView()
        setupListener()
    }

    private fun setupView() {
        tvid = findViewById(R.id.id_sapi)
        tvnama = findViewById(R.id.tv_nama)
        tvjk = findViewById(R.id.tv_jk)
        tvumur = findViewById(R.id.tv_umur)
        tvberat = findViewById(R.id.tv_berat)
        tvjenis = findViewById(R.id.tv_jenis)
        tvkondisi = findViewById(R.id.tv_kondisi)
        tvcatatan = findViewById(R.id.tv_catatan)
        tvliveact = findViewById(R.id.Act_live)
        tvliveloc = findViewById(R.id.Loc_live)
        updatebtn = findViewById(R.id.updateBTN)
        deletebtn = findViewById(R.id.ic_delete)
        tvid.setText(sapi.id)
        tvnama.setText(sapi.namacow)
        tvjk.setText(sapi.jkcow)
        tvumur.setText(sapi.umur)
        tvberat.setText(sapi.berat)
        tvjenis.setText(sapi.jenis)
        tvkondisi.setText(sapi.kondisi)
        tvcatatan.setText(sapi.catatan)
        tvliveact.setText(sapi.liveAct)
        tvliveloc.setText(sapi.liveLoc)

        sharedPreference = SharedPreference(this)
        val login_status = sharedPreference!!.getPreferenceString("login_status")

        if (login_status != "1"){
            deletebtn.visibility = View.INVISIBLE
//            updatebtn.setEnabled(false)
        }
    }

    private fun setupListener(){
        updatebtn.setOnClickListener {
            startActivity(
                Intent(this@viewInfo, UpdateReal::class.java)
                    .putExtra("sapi", sapi)
            )
        }

        deletebtn.setOnClickListener {
            val builder = AlertDialog.Builder(this@viewInfo)
            builder.setMessage("Apakah anda yakin ingin menghapus data?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    var deleto = deleteJson()
                    deleto.id = sapi.id
                    api.deletejson(deleto)
                        .enqueue(object : Callback<SubmitModel>{
                            override fun onResponse(
                                call: Call<SubmitModel>,
                                response: Response<SubmitModel>
                            ) {
                                if (response.isSuccessful){
                                    val submit = response.body()
                                    Toast.makeText(applicationContext, "Data dihapus", Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                            }

                            override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                                finish()
                            }

                        })
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

}