package com.mdplus.nineGridImageView

import android.content.Context
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.max

/**
 *作者：daboluo on 2024/9/14 16:12
 *Email:daboluo719@gmail.com
 * 让图片始终保持正方形
 */
class SquareImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    // 定义画笔
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        // 你可以在这里处理自定义属性（如：圆角半径）或初始化画笔等
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    // 保持长宽一致
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 取宽高的最小值，让长宽相等
        val size = max(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

}