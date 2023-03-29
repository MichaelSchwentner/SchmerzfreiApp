package com.example.schmerzfreiapp.ui.hilfsmittel

import android.content.Intent
import android.net.Uri
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

        binding.faszienballImage.setOnClickListener {
            val url = "https://amzn.to/3uMGef4"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.setImage.setOnClickListener {
            val url = "https://amzn.to/3MhSn75"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

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