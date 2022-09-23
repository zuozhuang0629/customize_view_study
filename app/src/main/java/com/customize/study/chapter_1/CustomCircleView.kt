package com.customize.study.chapter_1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customize.study.R

class CustomCircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBmp: Bitmap =
        BitmapFactory.decodeResource(resources, R.drawable.test)
    private var mPaint: Paint = Paint()
    private var mPath: Path = Path()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        val width = mBmp.width
        val height = mBmp.height
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLUE
        mPath.addCircle(width / 2f, height / 2f, width / 2f, Path.Direction.CCW)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        canvas?.clipPath(mPath)
        canvas?.drawBitmap(mBmp, 0f, 0f, mPaint)
        canvas?.restore()
    }
}