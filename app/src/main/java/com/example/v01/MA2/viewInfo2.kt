package com.example.v01.MA2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.v01.DataModel
import com.example.v01.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewInfo2 : AppCompatActivity() {

    private val sapi by lazy { intent.getSerializableExtra("sapi") as DataModel.Data }
//    private val api by lazy { APIRetrofit().endpoint }
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
//    private lateinit var deletebtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_info2)
        setupView()
//        setupListener()
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
//        deletebtn = findViewById(R.id.ic_delete)
        tvid.setText(sapi.id)
        tvnama.setText(sapi.namacow)
        tvjk.setText(sapi.jkcow)
        tvumur.setText(sapi.umur)
        tvberat.setText(sapi.berat)
        tvjenis.setText(sapi.jenis)
        tvkondisi.setText(sapi.kondisi)
        tvcatatan.setText(sapi.catatan)
        tvliveact.setText(sapi.live_act)
        tvliveloc.setText(sapi.live_loc)
        updatebtn.setEnabled(false)
    }

//    private fun setupListener(){
//        updatebtn.setOnClickListener {
//            startActivity(
//                Intent(this@viewInfo2, UpdateReal::class.java)
//                    .putExtra("sapi", sapi)
//            )
//        }
//
//        deletebtn.setOnClickListener {
//            api.delete(tvid.text.toString())
//                .enqueue(object: Callback<SubmitModel>{
//                    override fun onResponse(
//                        call: Call<SubmitModel>,
//                        response: Response<SubmitModel>
//                    ) {
//                        if(response.isSuccessful){
//                            val submit = response.body()
//                            Toast.makeText(applicationContext, submit!!.toString(),Toast.LENGTH_SHORT).show()
//                            finish()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
//                        finish()
//                    }
//
//                })
//        }
//    }

}