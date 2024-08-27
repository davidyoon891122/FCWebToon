package com.example.fcwebtoon

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.fcwebtoon.databinding.FragmentWebviewBinding

class WebViewFragment(private val position: Int): Fragment() {

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
        binding.webView.webViewClient = WebToonWebViewClient(binding.progressBar) { url ->
            activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)?.edit {
                putString("tab$position", url)
            }

        }
        binding.webView.loadUrl("https://comic.naver.com/webtoon/detail?titleId=183559&no=630&week=mon")


        binding.backToLastButton.setOnClickListener {
            val sharedPreference = activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)
            val url = sharedPreference?.getString("tab$position", "")
            if (url.isNullOrEmpty()) {
                Toast.makeText(context, "마지막 저장 시점이 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                binding.webView.loadUrl(url)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("WebViewFragment", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("WebViewFragment", "onStop")
    }

    fun canGoBack(): Boolean {
        return binding.webView.canGoBack()
    }

    fun goBack() {
        binding.webView.goBack()
    }

}