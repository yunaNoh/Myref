package com.example.barcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.barcode.databinding.Frag1Binding

class Fragment1 : Fragment () {

    private var _binding: Frag1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = Frag1Binding.inflate(inflater, container, false)
        return binding.root
    }







}