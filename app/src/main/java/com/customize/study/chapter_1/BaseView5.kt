package com.customize.study.chapter_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BaseView5 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //我不建议在ondraw中创建
        val paint = Paint()
        paint.color = Color.RED
        //大小和width有关
        paint.strokeWidth = 15f
        canvas!!.drawPoint(100f, 100F, paint)
    }
}