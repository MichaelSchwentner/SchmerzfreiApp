package com.example.schmerzfreiapp.ui.warmup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.schmerzfreiapp.MainViewModel
import com.example.schmerzfreiapp.adapter.WarmupAdapter
import com.example.schmerzfreiapp.data.model.Datasource
import com.example.schmerzfreiapp.data.remote.VimeoApi
import com.example.schmerzfreiapp.databinding.FragmentWarmupBinding
import com.example.schmerzfreiapp.ui.warmup.WarmupViewModel
import kotlinx.coroutines.launch

class WarmupFragment : Fragment() {

    private var _binding: FragmentWarmupBinding? = null
    private val viewModel: MainViewModel by activityViewModels()

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
        val titel = arguments?.getString("titel")

        binding.titelUebungen1Text.text = titel
        val datasource = Datasource()
        val uebungsbilderListe = datasource.getUebungsbilder3()

        //binding.uebungen3Recycler.adapter = WarmupAdapter(this, viewModel.videos.value!!.data)

        val root: View = binding.root

        val textView: TextView = binding.titelUebungen1Text
        //val textView2: TextView = binding.titelUebungen1Text
        warmupViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
         //   textView2.text = it
        }

        viewModel.videos.observe(viewLifecycleOwner){
            binding.uebungen3Recycler.adapter = WarmupAdapter(this, viewModel.videos.value!!.data)
        }
        println(viewModel.folder.value)
        for (folder in viewModel.folder.value!!.data){
            if (folder.name == titel){
                viewModel.setCurrentFolder(folder.uri.substringAfterLast("/"))
            }
        }
        viewModel.getVideo()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        const val CLIENT_ID = "3f9f080577e37606e1335bac7935236f513b3995"
        const val CLIENT_SECRET = "2b/XmwyMC5lw7gsZkCNJ7jdiVlhhs5h+tIbTKPQRjSeItUfZuZNpDOA6KCCVy2AA+uBGjlPQNT8XjutSWSdR3cPzsdYfPywgQl7Uvg+pl54XUd7YIvyYIL0BvX5M1egY"
        const val CODE_GRANT_REDIRECT_URL = "https://example.com"
        const val REQUEST_CODE = "12345"
        const val STAFF_PICKS_URI = "/channels/927/videos"
    }


}