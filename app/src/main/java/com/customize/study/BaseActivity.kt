package com.customize.study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    lateinit var _bind: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = initVB()
        setContentView(_bind.root)

        initView()
    }

    abstract fun initVB(): VB
    abstract fun initView()
}