package com.customize.study.chapter_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.customize.study.BaseActivity
import com.customize.study.R
import com.customize.study.databinding.ActivityChapter1Binding

class Chapter1Activity : BaseActivity<ActivityChapter1Binding>() {
    override fun initVB(): ActivityChapter1Binding = ActivityChapter1Binding.inflate(layoutInflater)
    override fun initView() {

    }

}