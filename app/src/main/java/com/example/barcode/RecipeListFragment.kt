package com.example.barcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.barcode.databinding.Frag3Binding

class Fragment3 : Fragment () {

    private var _binding: Frag3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = Frag3Binding.inflate(inflater, container, false)
        return binding.root
    }







}