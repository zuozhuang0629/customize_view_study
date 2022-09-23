package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.graphics.RectF


class BaseView9 @JvmOverloads constructor(
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

        val region = Region(Rect(50, 50, 200, 100))

        val iter = RegionIterator(region)
        val r = Rect()

        while (iter.next(r)) {
            canvas?.drawRect(r, paint);
        }

    }
}