package com.example.schmerzfreiapp.ui.UebungDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.widget.TextView
import android.widget.inline.InlineContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.schmerzfreiapp.R
import com.example.schmerzfreiapp.databinding.FragmentUebungDetailBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class UebungDetailFragment : Fragment() {

    private var _binding: FragmentUebungDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val uebungDetailViewModel =
            ViewModelProvider(this).get(UebungDetailViewModel::class.java)

        _binding = FragmentUebungDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textUebungDetail
        uebungDetailViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val uri = arguments?.getString("uri")
        println(uri)
//        val playerView = binding.videoPlayer
//        val videoUri = MediaItem.fromUri(uri!!)
//
//        val dataSourceFactory = DefaultHttpDataSource.Factory()
//        val mediaSource = HlsMediaSource.Factory(dataSourceFactory).createMediaSource(videoUri)
//
//        val player = ExoPlayer.Builder(requireContext()).build()
//        player.setMediaSource(mediaSource)
//
//// Attach player to your view or surface
//        playerView.player = player
//
//// Start playback when ready
//        player.playWhenReady = true

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val uri = arguments?.getString("uri")
        var webview = binding.webViews
        webview.settings.javaScriptEnabled=true
        webview.webChromeClient = WebChromeClient()
        webview.settings.domStorageEnabled = true

        if (uri != null) {
            webview.loadUrl(uri)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}