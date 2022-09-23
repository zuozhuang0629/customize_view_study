package com.customize.study.chapter_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.customize.study.BaseActivity
import com.customize.study.databinding.ActivityChapter2Binding

class Chapter2Activity : BaseActivity<ActivityChapter2Binding>() {
    override fun initVB(): ActivityChapter2Binding {
        return ActivityChapter2Binding.inflate(layoutInflater)
    }

    override fun initView() {

    }

}