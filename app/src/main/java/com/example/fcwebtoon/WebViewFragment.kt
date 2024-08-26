package com.example.fcwebtoon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.fcwebtoon.databinding.FragmentWebviewBinding

class WebViewFragment: Fragment() {

    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("WebViewFragment", "onCreateView")
        binding = FragmentWebviewBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("WebViewFragment", "onViewCreated")

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("https://google.com")

    }

    override fun onStart() {
        super.onStart()
        Log.d("WebViewFragment", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("WebViewFragment", "onStop")
    }

}