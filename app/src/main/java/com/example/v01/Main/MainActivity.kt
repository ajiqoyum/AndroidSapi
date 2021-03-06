package com.example.v01.Main

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.v01.API.APIRetrofit
import com.example.v01.Adapter.CowAdapter
import com.example.v01.API.DataModel
import com.example.v01.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.FirebaseApp
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //   !!!Weather API masih belum bisa dipakai!!!

    private lateinit var setting:Toolbar
    private val api by lazy { APIRetrofit().endpoint }
//    private val weather by lazy { intent.getSerializableExtra("weather") as Cuaca.Main }
    private lateinit var sapiAdapter: CowAdapter
//    private lateinit var cuacaAdapter : WeatherAdapter
    private lateinit var listSapi:RecyclerView
    private lateinit var createBTN: FloatingActionButton
    private lateinit var userprofile : CircleImageView
    var sharedPreference:SharedPreference? = null
//    private lateinit var suhu:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setting =findViewById(R.id.toolbarku)
        setSupportActionBar(setting)
        supportActionBar!!.title = "Ternak"
        setupView()
        setupList()
        setupListener()
    }

    override fun onStart() {
        super.onStart()
//        getsuhu()
        getsapi()
    }

    private fun setupView(){
        sharedPreference = SharedPreference(this)
        val login_status = sharedPreference!!.getPreferenceString("login_status")

        listSapi = findViewById(R.id.RV_Sapi)
        createBTN = findViewById(R.id.create_btn)
        userprofile = findViewById(R.id.userdetails)

        if (login_status != "1"){
            createBTN.visibility = View.INVISIBLE
        }
//        suhu = findViewById(R.id.temperatur)
//        suhu.setText(cuacaAdapter.cuaca.temp.toString())
    }

    private fun setupList(){
        //Klik item recyclerview menuju activity viewInfo
        sapiAdapter = CowAdapter(arrayListOf(), object : CowAdapter.OnAdapterListener{
            override fun onClick(sapi: DataModel.Data) {
                startActivity(
                    Intent(this@MainActivity, viewInfo::class.java)
                        .putExtra("sapi", sapi)
                )
            }
        })
        listSapi.adapter =sapiAdapter

        //Kode untuk mendapatkan Device Token untuk notifikasi
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if(!task.isSuccessful) {
                return@addOnCompleteListener
            }
            val token = task.result

            Log.e("Token   ======>", token)
        }
    }

    private fun setupListener(){
        createBTN.setOnClickListener {
            startActivity(Intent(this, createInfo::class.java))
        }
        userprofile.setOnClickListener {
            startActivity(Intent(this, User::class.java))
        }
    }

    private fun getsapi() {
        api.data().enqueue(object : Callback<DataModel>{
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if(response.isSuccessful){
                    val listData = response.body()!!.data
                    sapiAdapter.setData(listData)
                }
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {

            }

        })
    }

//    private val API_KEY = "aec68c224da94ee816c76842a479794f"
//
//    private fun getsuhu(){
//        val client = APIconfig.getAPIService().getWeather("0.43","117.31", API_KEY,"metric")
//        client.enqueue(object : Callback<Cuaca>{
//            override fun onResponse(call: Call<Cuaca>, response: Response<Cuaca>) {
//                if (response.isSuccessful) {
//                    val Suhu = response.body()!!.main
//                    cuacaAdapter.setData2(Suhu)
//                }
//            }
//
//            override fun onFailure(call: Call<Cuaca>, t: Throwable) {
//            }
//
//        })
//    }
}