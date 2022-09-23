package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class BaseView16 @JvmOverloads constructor(
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


        //两个矩形
        val rect1 = Rect(100, 100, 400, 200)
        val rect2 = Rect(200, 0, 300, 300)

        canvas?.drawRect(rect1, paint);
        canvas?.drawRect(rect2, paint);


        //构造两个区域
        val region = Region(rect1)
        val region2 = Region(rect2)

        //取两个区域的并集
        region.op(region2, Region.Op.UNION);

        val paint_fill = Paint();
        paint_fill.color = Color.GREEN;
        paint_fill.style = Paint.Style.FILL;
        drawRegion(canvas, region, paint_fill)
    }

    private fun drawRegion(canvas: Canvas?, rgn: Region, paint: Paint) {
        val iter = RegionIterator(rgn)
        val r = Rect()
        while (iter.next(r)) {
            canvas?.drawRect(r, paint)
        }
    }
}