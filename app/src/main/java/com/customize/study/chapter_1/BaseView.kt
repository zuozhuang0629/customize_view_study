package com.customize.study.chapter_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BaseView @JvmOverloads constructor(
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

//        Paint.Style.FILL:仅填充内部。
//        Paint.Style.FILL_AND_STROKE:填充内部和描边。
//        Paint.Style.STROKE:仅描边
        paint.style = Paint.Style.STROKE

        //设置画笔宽度
        paint.strokeWidth = 50F

        //画圆
        canvas?.drawCircle(190F, 200F, 150F, paint)
    }
}