package com.mdplus.nineGridImageView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap
import kotlin.math.max

/**
 *作者：daboluo on 2024/9/14 16:12
 *Email:daboluo719@gmail.com
 * 让图片始终保持正方形
 * 还有一个要求哦
 * 如果图片是单张，最好设一个最大宽高
 * 要求图片带弧度：实现方法SquareImageView+CardLayout实现
 */
class SquareImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    // 定义画笔
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    //定义路径
    private val path = Path()
    private var cornerRadius = 20f // 圆角半径
    private var maxSingleImageWidth: Int = 500 // 单张图片的最大宽度

    init {
        // 你可以在这里处理自定义属性（如：圆角半径）或初始化画笔等
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    // 保持长宽一致
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 取宽高的最小值，让长宽相等
        var size = max(measuredWidth, measuredHeight)
        // 设置最大尺寸
        if (size > maxSingleImageWidth) {
            size = maxSingleImageWidth
        }
        setMeasuredDimension(size, size)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val bitmap = drawable?.toBitmap() // 获取位图
        if (bitmap != null) {
            path.reset()
            val rect = RectF(0f, 0f, width.toFloat(), height.toFloat())
            path.addRoundRect(rect, cornerRadius, cornerRadius, Path.Direction.CW)
            canvas.clipPath(path)
            canvas.drawBitmap(bitmap, null, rect, paint)
        }
        super.onDraw(canvas)
    }

    /**
     * 设置单张图片的最大宽度
     * @param maxWidth 最大宽度
     */
    fun setMaxSingleImageWidth(maxWidth: Int) {
        this.maxSingleImageWidth = maxWidth
        requestLayout() // 请求重新布局
    }
}
