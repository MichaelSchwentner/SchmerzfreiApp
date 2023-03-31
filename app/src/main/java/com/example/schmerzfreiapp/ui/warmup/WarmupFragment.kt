package com.example.schmerzfreiapp.ui.warmup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.schmerzfreiapp.adapter.WarmupAdapter
import com.example.schmerzfreiapp.data.model.Datasource
import com.example.schmerzfreiapp.databinding.FragmentWarmupBinding
import com.example.schmerzfreiapp.ui.warmup.WarmupViewModel

class WarmupFragment : Fragment() {

    private var _binding: FragmentWarmupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val warmupViewModel =
            ViewModelProvider(this).get(WarmupViewModel::class.java)

        _binding = FragmentWarmupBinding.inflate(inflater, container, false)

        val datasource = Datasource()
        val uebungsbilderListe = datasource.getUebungsbilder3()
        binding.uebungen3Recycler.adapter = WarmupAdapter(this, uebungsbilderListe)

        val root: View = binding.root

        val textView: TextView = binding.titelUebungen1Text
        val textView2: TextView = binding.titelUebungen1Text
        warmupViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
            textView2.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}