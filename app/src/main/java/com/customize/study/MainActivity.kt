package com.customize.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.customize.study.chapter_1.Chapter1Activity
import com.customize.study.chapter_2.Chapter2Activity
import com.customize.study.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initVB(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    override fun initView() {
        _bind.recycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter().apply {
                setList(getList())
                addChildClickViewIds(R.id.card)
                setOnItemChildClickListener(itemClick)
            }
        }
    }


    val itemClick =
        OnItemChildClickListener { adapter, view, position ->
            when (position) {
                0 -> {
                    startActivity(Intent(this, Chapter1Activity::class.java))
                }
                1 -> {
                    startActivity(Intent(this, Chapter2Activity::class.java))
                }
                2 -> {}
                3 -> {}
                else -> {}
            }


        }

    fun getList(): List<String> {
        return arrayListOf("绘画基础", "动画篇", "绘图篇", "视图篇")
    }

}