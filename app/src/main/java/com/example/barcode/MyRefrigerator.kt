package com.example.barcode

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyRefrigerator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intentData = intent.getStringExtra("intentDataKey")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = intentData
    }
}