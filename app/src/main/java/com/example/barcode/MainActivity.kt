package com.example.barcode

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.barcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var requestCamera: ActivityResultLauncher<String>? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                startBarcodeScanActivity()
            } else {
                Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btn.setOnClickListener {
            requestCamera?.launch(Manifest.permission.CAMERA)
        }
    }

    private fun startBarcodeScanActivity() {
        val intent = Intent(this, BarcodeScan::class.java)
        startActivity(intent)
    }
}
