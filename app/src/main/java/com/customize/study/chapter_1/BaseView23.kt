package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class BaseView23 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.RED)
        canvas?.save()

        canvas?.clipRect(Rect(100, 100, 800, 800))
        canvas?.drawColor(Color.GREEN)
        canvas?.save()

        canvas?.clipRect(Rect(200, 200, 700, 700))
        canvas?.drawColor(Color.BLUE)
        canvas?.save()

        canvas?.clipRect(Rect(300, 300, 600, 600))
        canvas?.drawColor(Color.BLACK)
        canvas?.save()

        canvas?.clipRect(Rect(400, 400, 500, 500))
        canvas?.drawColor(Color.WHITE)
        canvas?.save()

        canvas?.restore()
        canvas?.restore()
        canvas?.restore()
        canvas?.restore()
        canvas?.drawColor(Color.YELLOW)


    }

}