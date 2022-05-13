package com.example.datetimepluginproject


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.passcode_layout.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var counter = 0
    var password = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()
        callWebView("https://krishworks.com")

        buttonClicks()


    }

    private fun buttonClicks() {

        about_us.setOnClickListener {
            callWebView("https://krishworks.com/about/")
            about_us.apply {
                setBackgroundResource(R.drawable.rounded_corner_tabbar)
            }
            home.apply {
                setBackgroundResource(0)
            }
            updates.apply {
                setBackgroundResource(0)
            }
        }
        updates.setOnClickListener {
            callWebView("https://krishworks.com/updates/")

            updates.apply {
                setBackgroundResource(R.drawable.rounded_corner_tabbar)
            }
            about_us.apply {
                setBackgroundResource(0)
            }
            home.apply {
                setBackgroundResource(0)
            }

        }
        home.setOnClickListener {
            callWebView("https://krishworks.com")
            home.apply {
                setBackgroundResource(R.drawable.rounded_corner_tabbar)
            }
            about_us.apply {
                setBackgroundResource(0)
            }
            updates.apply {
                setBackgroundResource(0)
            }
        }

        btnhit.setOnClickListener {
            passcode.visibility = View.VISIBLE
        }

        digit1.setOnClickListener {
            keyboadlayout.visibility = View.VISIBLE
            digit1.text = "|"
        }

        btn0.setOnClickListener {
            addText(0)
        }
        btn1.setOnClickListener {
            addText(1)
        }
        btn2.setOnClickListener {
            addText(2)
        }
        btn3.setOnClickListener {
            addText(3)
        }
        btn4.setOnClickListener {
            addText(4)
        }
        btn5.setOnClickListener {
            addText(5)
        }
        btn6.setOnClickListener {
            addText(6)
        }
        btn7.setOnClickListener {
            addText(7)
        }
        btn8.setOnClickListener {
            addText(8)
        }
        btn9.setOnClickListener {
            addText(9)
        }
    }

    private fun addText(s: Int) {

        password = password*10 + s

        if(counter == 0){
            digit1.text = s.toString()
            counter++
            digit2.text = "|"
        }else if(counter == 1){
            digit2.text = s.toString()
            counter++
        }else if(counter == 2){
            digit3.text = s.toString()
            counter++
            digit4.text = "|"
        }else if (counter == 3){
            digit4.text = s.toString()
            counter++
            digit5.text = "|"
        }else if (counter == 4){
            digit5.text = s.toString()
            counter++
            digit6.text = "|"
        }else {
            digit6.text = s.toString()
            counter = 0

            validatePassword()
        }
    }

    private fun validatePassword() {
        if(password.toString() == getPassword()){
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)

        }else{

            passcode.visibility = View.GONE
            digit1.text = ""
            digit2.text = ""
            digit3.text = ""
            digit4.text = ""
            digit5.text = ""
            digit6.text = ""

            Toast.makeText(this,"Incorrect Password...!",Toast.LENGTH_SHORT).show()
        }

        password = 0
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun callWebView(url:String) {
        webView.webViewClient = WebViewClient()

        webView.apply {
            loadUrl(url)
            settings.javaScriptEnabled = true
        }
    }

    @JvmName("getPassword1")
    private fun getPassword(): String {
        val cal = Calendar.getInstance()

        val dd = cal.get(Calendar.DAY_OF_MONTH)
        val mm = cal.get(Calendar.MONTH)
        val yy = cal.get(Calendar.YEAR)

        return (dd * (mm + 1)* yy).toString()
    }
}