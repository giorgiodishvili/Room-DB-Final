package com.android.fridaytaskapplication.extensions

import android.app.Dialog
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.viewbinding.ViewBinding

fun Dialog.setUp(binding: ViewBinding, color: Int, height: Int){

    requestWindowFeature(Window.FEATURE_NO_TITLE)
    setContentView(binding.root)
    window!!.setBackgroundDrawableResource(color)
    val lp = WindowManager.LayoutParams()
    lp.copyFrom(window!!.attributes)
    lp.width = WindowManager.LayoutParams.MATCH_PARENT
    lp.height = height
    lp.gravity = Gravity.CENTER
    window!!.attributes = lp
}