package com.example.tesktaskauth

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val androidid: String  = Settings.Secure.getString(this.contentResolver,Settings.Secure.ANDROID_ID)
        Log.i("Android Unique id","Unique id is ${androidid}")

    }
}