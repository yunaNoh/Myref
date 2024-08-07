package com.example.barcode

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.barcode.databinding.ActivityIngredientListBinding
import com.google.firebase.firestore.FirebaseFirestore

class IngredientListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIngredientListBinding
    private lateinit var adapter: IngredientAdapter
    private val ingredientList = mutableListOf<Ingredient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngredientListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = IngredientAdapter(ingredientList)
        binding.ingredientRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.ingredientRecyclerView.adapter = adapter

        fetchDataFromFirestore()
    }

    private fun fetchDataFromFirestore() {
        val db = FirebaseFirestore.getInstance()
        db.collection("ingredients")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val name = document.getString("name") ?: ""
                    val expiryDate = document.getString("expiryDate") ?: ""
                    val ingredient = Ingredient(name, expiryDate)
                    ingredientList.add(ingredient)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                // 에러 처리 로직
            }
    }
}