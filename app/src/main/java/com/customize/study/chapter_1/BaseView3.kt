package com.customize.study.chapter_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BaseView3 @JvmOverloads constructor(
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
        //设置填充样式--填充
        paint.style = Paint.Style.FILL
        //设置画笔宽度
        paint.strokeWidth = 50F
        //画圆
        canvas?.drawCircle(150F, 200F, 150F, paint)

        paint.style = Paint.Style.STROKE
        //(150F * 2) 前一个远的直径
        // 150F 本园的半径
        //25 笔宽的一半
        canvas?.drawCircle((150F * 2) + 150F + 25, 200F, 150F, paint)

        paint.style = Paint.Style.FILL_AND_STROKE
        //和上面计算一样
        canvas?.drawCircle((150F * 2) + 150F + 25 + (150F * 2) + 25 + 25, 200F, 150F, paint)

    }
}