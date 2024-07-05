/*package com.example.barcode

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
 */
package com.example.barcode

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.barcode.databinding.Frag1Binding

class Fragment1 : Fragment() {

    private var _binding: Frag1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = Frag1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBarcode.setOnClickListener {
            val intent = Intent(activity, BarcodeScan::class.java)
            startActivity(intent)
        }

        binding.btnDirect.setOnClickListener {
            val intent = Intent(activity, ManualEntry::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
