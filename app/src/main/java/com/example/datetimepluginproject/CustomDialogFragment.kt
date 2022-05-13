package com.example.datetimepluginproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.passcode_layout.*

class CustomDialogFragment:Fragment() {
    val thee = R.style.MyDialog
    val style = DialogFragment.STYLE_NO_TITLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:View = inflater.inflate(R.layout.passcode_layout,container,false)
//        digit1.setOnClickListener {
//            keyboadlayout.visibility = View.INVISIBLE
//            digit1.text = "1"
//        }
        return rootView
    }
}
