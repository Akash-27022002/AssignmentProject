package com.example.datetimepluginproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.setting_layout.*

class SecondActivity : AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_layout)
        actionBar?.hide()
        callWebView("https://krishworks.com/gallery")
        setting.apply {
            focusable = View.FOCUSABLE
            requestFocus()
        }
        gallery.setOnClickListener {
            callWebView("https://krishworks.com/gallery")
            contactus.apply {
                setBackgroundColor(resources.getColor(R.color.white))
                setTextColor(resources.getColor(R.color.black))
            }
            gallery.apply {
                setBackgroundColor(resources.getColor(R.color.numberActionButton))
                setTextColor(resources.getColor((R.color.imp)))
            }

        }
        contactus.setOnClickListener {
            callWebView("https://krishworks.com/contact")
            gallery.apply {
                setBackgroundColor(resources.getColor(R.color.white))
                setTextColor(resources.getColor(R.color.black))
            }
            contactus.apply {
                setBackgroundColor(resources.getColor(R.color.numberActionButton))
                setTextColor(resources.getColor((R.color.imp)))
            }

            close.setOnClickListener {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }

        }








    }

    private fun callWebView(url:String) {
        webView2.webViewClient = WebViewClient()

        webView2.apply {
            loadUrl(url)
        }
    }


}