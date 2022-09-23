package com.customize.study.chapter_1

import android.R.attr
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.lang.Math.sin
import kotlin.math.cos
import android.R.attr.data





class SpiderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var radarPaint: Paint = Paint()
    private var valuePaint: Paint = Paint()

    init {
        radarPaint.style = Paint.Style.STROKE
        radarPaint.color = Color.GREEN

        valuePaint.style = Paint.Style.FILL
        valuePaint.color = Color.BLUE

    }

    //半径
    private var radius = 0f

    //中心x
    private var centerX = 0f

    //中心y
    private var centerY = 0f

    private val count = 6
    private val angle = (Math.PI * 2f / count)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        //获取半径  width和height的最短的90%
        radius = h.coerceAtMost(w) / 2 * 0.9f

        //获取中心坐标
        centerX = w / 2f
        centerY = h / 2f

        //刷新控件
        postInvalidate()
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //绘制蜘蛛网格
        drawPolygon(canvas)
        //画网格中线
        drawLine(canvas)
        //画数据图
        drawRegion(canvas)

    }

    private fun drawPolygon(canvas: Canvas) {

        val path = Path()

        val r = radius / count

        for (index in 0..count) {
            val curR = r * index
            path.reset()
            for (j in 0..count) {
                if (j == 0) {
                    path.moveTo(centerX + curR, centerY)
                } else {
                    val x = centerX + curR * Math.cos((angle * j))
                    val y = centerY + curR * sin((angle * j))

                    path.lineTo(x.toFloat(), y.toFloat())
                }
            }

            path.close()
            canvas.drawPath(path, radarPaint)
        }

    }

    private fun drawLine(canvas: Canvas) {
        val path = Path()
        for (index in 0..count) {
            path.reset()
            path.moveTo(centerX, centerY)

            val x = centerX + radius * Math.cos((angle * index))
            val y = centerY + radius * sin((angle * index))

            path.lineTo(x.toFloat(), y.toFloat())

            canvas.drawPath(path,radarPaint)
        }

    }
    private val data = doubleArrayOf(2.0, 5.0, 1.0, 6.0, 4.0, 5.0)
    private fun drawRegion(canvas: Canvas) {
        val path = Path()
        valuePaint.alpha = 127
        for (i in 0 until count) {
            val percent: Double = data.get(i) / 6
            val x = (centerX + radius * Math.cos(angle * i) * percent).toFloat()
            val y = (centerY + radius * sin(angle * i) * percent).toFloat()
            if (i == 0) {
                path.moveTo(x, centerY)
            } else {
                path.lineTo(x, y)
            }
            //绘制小圆点
            canvas.drawCircle(x, y, 10f, valuePaint)
        }
        //绘制填充区域
        valuePaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawPath(path, valuePaint)
    }
}