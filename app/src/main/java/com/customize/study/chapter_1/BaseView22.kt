package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class BaseView22 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.RED)
        canvas?.clipRect(Rect(100,100,200,200))
        canvas?.drawColor(Color.GREEN)
    }

}