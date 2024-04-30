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
    // 변수 선언: 카메라 권한 요청을 처리하기 위한 ActivityResultLauncher
    private var requestCamera: ActivityResultLauncher<String>? = null // ActivityResultLauncher: 카메라 권한 요청에 대한 결과를 처리하기 위한 인터페이스
    private lateinit var binding: ActivityMainBinding // 레이아웃 바인딩은 안드로이드 앱에서 뷰를 코드에 직접 참조할 수 있게 해주는 기술입니다. 이를 통해 XML 레이아웃 파일에서 정의한 뷰들을 코드에서 간편하게 사용할 수 있음

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // 액티비티의 콘텐츠 뷰로 설정할 레이아웃을 지정합니다 , binding.root는 인플레이트된 XML 레이아웃 파일의 최상위 뷰를 나타냅니다. 따라서 이 코드는 해당 액티비티의 콘텐츠 뷰를 인플레이트된 XML 레이아웃 파일로 설정합니다.

        // 카메라 권한 요청에 대한 결과를 처리하기 위한 ActivityResultLauncher 설정
        requestCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            // 권한이 허용되면 바코드 스캔 액티비티를 시작, 그렇지 않으면 퍼미션 거부 메시지 출력
            if (isGranted) {
                startBarcodeScanActivity()
            } else {
                Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_SHORT).show()
            }
        }

        // 버튼 클릭 시 카메라 권한 요청
        binding.btn.setOnClickListener {
            requestCamera?.launch(Manifest.permission.CAMERA)
        }
    }

    // 바코드 스캔 액티비티 시작 함수
    private fun startBarcodeScanActivity() {
        val intent = Intent(this, BarcodeScan::class.java)
        startActivity(intent)
    }
}
