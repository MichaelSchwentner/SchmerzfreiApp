package com.example.schmerzfreiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.schmerzfreiapp.adapter.HomeAdapter
import com.example.schmerzfreiapp.adapter.HometwoAdapter
import com.example.schmerzfreiapp.data.model.Datasource
import com.example.schmerzfreiapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val datasource = Datasource()
        val uebungsbilderListe = datasource.getUebungsbilder()
        binding.rec2.adapter = HomeAdapter( uebungsbilderListe)
        binding.imageScrollerHRv.adapter = HometwoAdapter(uebungsbilderListe)

////        val textView: TextView = binding.textHome
////        homeViewModel.text.observe(viewLifecycleOwner) {
////            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}