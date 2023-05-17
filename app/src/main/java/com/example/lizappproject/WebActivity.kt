package com.example.lizappproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class WebActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var auth: FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webview)
        auth = Firebase.auth

        webview()



            }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webview() {
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("https://www.hinshawlaw.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }



        }


    }

