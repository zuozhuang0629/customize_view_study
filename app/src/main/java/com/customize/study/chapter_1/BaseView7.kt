package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BaseView7 @JvmOverloads constructor(
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
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE

        val path = Path()
        //设置起点
        path.moveTo(10f, 10f)
        //第一条线直线的终点，第二条线的起点
        path.lineTo(10f, 100f)
        // 第二条线
        path.lineTo(300f, 100f)
        //闭环
        path.close()

        canvas?.drawPath(path, paint)


    }
}