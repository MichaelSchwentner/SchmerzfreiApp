package com.example.schmerzfreiapp.ui.gesundheitstipps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.schmerzfreiapp.databinding.FragmentGesundheitstippsBinding

class GesundheitstippsFragment : Fragment() {

    private var _binding: FragmentGesundheitstippsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val gesundheitstippsViewModel =
            ViewModelProvider(this).get(GesundheitstippsViewModel::class.java)

        _binding = FragmentGesundheitstippsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.gesundheitstippsImage.setOnClickListener {
            Toast.makeText(context, "Einleitungsvideo ist noch in Bearbeitung...", Toast.LENGTH_SHORT).show()
        }

        binding.textView12.setOnClickListener {
            Toast.makeText(context, "Einleitungsvideo ist noch in Bearbeitung...", Toast.LENGTH_SHORT).show()
        }

        val textView: TextView = binding.textGesundheitstipps
        gesundheitstippsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}