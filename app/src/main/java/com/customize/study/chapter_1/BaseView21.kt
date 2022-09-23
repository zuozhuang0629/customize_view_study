package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class BaseView21 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //我不建议在ondraw中创建
        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f

        val paint_greent = generatePaint(color = Color.GREEN, style = Paint.Style.STROKE, 3f)
        val paint_red = generatePaint(color = Color.RED, style = Paint.Style.STROKE, 3f)

        val rect = Rect(10, 10, 200, 100)
        canvas?.drawRect(rect,paint_greent)
        canvas?.skew(1.732f,0f)
        canvas?.drawRect(rect,paint_red)
    }


    fun generatePaint(color: Int, style: Paint.Style, width: Float): Paint {
        return Paint().apply {
            this.color = color
            this.style = style
            this.strokeWidth = width
        }
    }
}