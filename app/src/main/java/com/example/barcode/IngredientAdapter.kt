package com.example.barcode

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.barcode.databinding.IngredientItemBinding
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView


class IngredientAdapter(private val ingredientList: List<Ingredient>) :
    RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding = IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredientList[position])
    } //각 아이템 뷰에 데이터 바인딩

    override fun getItemCount(): Int = ingredientList.size //리스트의 아이템 개수 반환

    class IngredientViewHolder(private val binding: IngredientItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: Ingredient) {
            binding.ingredient = ingredient
            binding.executePendingBindings()
        }
    }
}