package com.example.barcode
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barcode.databinding.ActivityMyRefrigeratorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MyRefrigerator : AppCompatActivity() {
    interface ProductApiService {
        @GET("products")
        fun getProductByBarcode(@Query("barcode") barcode: String): Call<Product>
    }

    data class Product(
        val name: String,
        val price: Double,
        val description: String
    )

    private lateinit var binding: ActivityMyRefrigeratorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRefrigeratorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentData = intent.getStringExtra("intentDataKey") ?: "바코드 정보 없음"
        binding.textView.text = intentData
//        if (intentData != "바코드 정보 없음") {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://your-api-url.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            val apiService = retrofit.create(ProductApiService::class.java)
//            apiService.getProductByBarcode(intentData).enqueue(object : Callback<Product> {
//                override fun onResponse(call: Call<Product>, response: Response<Product>) {
//                    if (response.isSuccessful) {
//                        response.body()?.let { product ->
//                            binding.textView.text = product.name
//                            Log.d("MyRefrigerator", "Product name: ${product.name}")
//                            Log.d("MyRefrigerator", "Product : ${product}")
//                        }
//                    } else {
//                        Log.e("MyRefrigerator", "Response not successful")
//                    }
//                }
//
//                override fun onFailure(call: Call<Product>, t: Throwable) {
//                    Log.e("MyRefrigerator", "Error fetching product data", t)
//                    Toast.makeText(this@MyRefrigerator, "제품 정보를 가져오는 데 실패했습니다.", Toast.LENGTH_LONG).show()
//                }
//            })
//        }
    }
}