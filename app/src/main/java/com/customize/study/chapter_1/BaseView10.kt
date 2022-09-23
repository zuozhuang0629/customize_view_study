package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class BaseView10 @JvmOverloads constructor(
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

        //构造椭圆路劲
        val ovalPath = Path()
        val rectF = RectF(50f, 50f, 200f, 500f)
        ovalPath.addOval(rectF, Path.Direction.CCW)

        val rgn = Region()
        //根据路径的区域与某区域的交集构造出新的区域
        rgn.setPath(ovalPath, Region(50, 50, 200, 200))

        drawRegion(canvas, rgn, paint)
    }

    private fun drawRegion(canvas: Canvas?, rgn: Region, paint: Paint) {
        val iter = RegionIterator(rgn)
        val r = Rect()
        while (iter.next(r)) {
            canvas?.drawRect(r, paint)
        }
    }
}