package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.graphics.RectF


class BaseView8 @JvmOverloads constructor(
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
        //生成椭圆的矩形
        var rectF = RectF(100f, 10f, 200f, 100f)
        //  startAngle：弧开始的角度，x轴正方向为0°
        //sweepAngle:弧持续的角度
        path.arcTo(rectF, 0f, 90f)

        canvas?.drawPath(path, paint)

        rectF = RectF(200f, 10f, 300f, 100f)
        path.arcTo(rectF, 0f, 90f, true)
        canvas?.drawPath(path, paint)

    }
}