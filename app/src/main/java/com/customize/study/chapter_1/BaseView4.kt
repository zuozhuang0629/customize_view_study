package com.customize.study.chapter_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BaseView4 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //我不建议在ondraw中创建
        val paint = Paint()
        //设置画笔颜色
        paint.color = Color.RED
        // 划线这个属性没有关系
        paint.style = Paint.Style.FILL
        //设置画笔宽度
        paint.strokeWidth = 50F
        //画线
        canvas?.drawLine(100F, 100F, 200F, 200F,paint)

        //画线
        paint.strokeWidth = 5F
        canvas?.drawLine(200F, 100F, 300F, 200F,paint)
    }
}