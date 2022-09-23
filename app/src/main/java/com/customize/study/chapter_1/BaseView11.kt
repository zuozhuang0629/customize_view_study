package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class BaseView11 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //我不建议在ondraw中创建
        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL


        val region = Region(10, 10, 200, 100)
        //该函数用于与指定矩形取并集，即将 Rect 所指定的矩形加入当前区域中
        //简单说就是将两个区域合并在一起
        region.union(Rect(10, 10, 50, 300))
        drawRegion(canvas,region,paint)

    }

    private fun drawRegion(canvas: Canvas?, rgn: Region, paint: Paint) {
        val iter = RegionIterator(rgn)
        val r = Rect()
        while (iter.next(r)) {
            canvas?.drawRect(r, paint)
        }
    }
}