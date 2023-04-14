package com.example.schmerzfreiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.schmerzfreiapp.MainViewModel
import com.example.schmerzfreiapp.adapter.HomeAdapter
import com.example.schmerzfreiapp.adapter.HometwoAdapter
import com.example.schmerzfreiapp.data.model.Datasource
import com.example.schmerzfreiapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: MainViewModel by viewModels()

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
        val uebungsbilderHorizontal = datasource.getUebungsbilder2()
        binding.rec2.adapter = HomeAdapter( uebungsbilderListe)
        binding.imageScrollerHRv.adapter = HometwoAdapter(uebungsbilderHorizontal)

        var videoURL: String = "540807840"
        viewModel.getFolder()
        viewModel.folder.observe(viewLifecycleOwner){
            println(viewModel.folder.value)
        }



//        binding.rec2.setOnClickListener {
//            println("loading Data")
//            lifecycleScope.launch {
//                val response: Response<User> = VimeoApi.retrofitService.getVideoInfo("https://api.vimeo.com/videos/" + videoURL)
//                if (response.isSuccessful) {
//                    println(response.raw())
//                    val user: User? = response.body()
//                    println(user?.name)
//                    binding.textviewFirst.text = user?.name
//                }else{
//                    println("Someting went wrong")
//                    println(response.raw())
//                }
//            }
//
//        }
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