package com.example.schmerzfreiapp.ui.hilfsmittel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.schmerzfreiapp.databinding.FragmentHilfsmittelBinding


class HilfsmittelFragment : Fragment() {

    private var _binding: FragmentHilfsmittelBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val hilfsmittelViewModel =
            ViewModelProvider(this).get(HilfsmittelViewModel::class.java)

        _binding = FragmentHilfsmittelBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHilfsmittel
        hilfsmittelViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}