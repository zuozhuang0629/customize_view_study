package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BaseView6 @JvmOverloads constructor(
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
        paint.style  = Paint.Style.STROKE

        //画矩形 直接构造函数
        canvas!!.drawRect(10f, 10f,100f,100f, paint)

        paint.style  = Paint.Style.FILL
        val rect = RectF(210f,10f,300f,100f)
        canvas?.drawRect(rect,paint)

    }
}