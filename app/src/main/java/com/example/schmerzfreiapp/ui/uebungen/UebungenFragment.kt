package com.example.schmerzfreiapp.ui.uebungen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.schmerzfreiapp.adapter.UebungAdapter
import com.example.schmerzfreiapp.adapter.WarmupAdapter
import com.example.schmerzfreiapp.data.model.Datasource
import com.example.schmerzfreiapp.databinding.FragmentUebungenBinding

class UebungenFragment : Fragment() {

    private var _binding: FragmentUebungenBinding? = null
    private val viewModel: UebungenViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val uebungenViewModel =
            ViewModelProvider(this).get(UebungenViewModel::class.java)

        _binding = FragmentUebungenBinding.inflate(inflater, container, false)


        viewModel.categories.observe(viewLifecycleOwner){
            binding.uebungenRecycler.adapter = UebungAdapter(this, viewModel.categories.value!!)
        }


        val root: View = binding.root

        val textView: TextView = binding.titelUebungen1Text
        val textView2: TextView = binding.titelUebungen1Text

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}