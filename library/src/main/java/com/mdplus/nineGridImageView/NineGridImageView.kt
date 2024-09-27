package com.mdplus.nineGridImageView

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 *作者：daboluo on 2024/9/14 15:18
 *Email:daboluo719@gmail.com
 */
class NineGridImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    // 控制是否自动分布布局
    private var isAutoDistributed: Boolean = false

    private var imageLoading: Drawable? = null
    private var imageLoadedError: Drawable? = null

    init {
        // 初始化代码块（如果有需要）
    }

    /**
     * 设置图片 URL 列表
     * @param imageUrls 图片的 URL 列表
     */
    fun setImageUrls(imageUrls: List<String>) {
        // 根据图片数量设置 LayoutManager
        updateLayoutManager(imageUrls.size)
        // 设置适配器
        adapter = ImageGridAdapter(context, imageUrls, imageLoading, imageLoadedError)
    }

    /**
     * 根据图片数量设置布局管理器（LayoutManager）
     * @param imageCount 图片的数量
     */
    private fun updateLayoutManager(imageCount: Int) {
        val columns = if (isAutoDistributed) {
            getOptimalColumnsNumber(imageCount)
        } else {
            3 // 默认 3 列布局
        }
        layoutManager = NoScrollGridLayoutManager(context, columns)
    }

    /**
     * 启用或禁用自动分布
     * @param isEnabled 是否启用自动分布
     */
    fun setAutoDistribution(isEnabled: Boolean = false) {
        this.isAutoDistributed = isEnabled
    }

    /**
     * 获取最佳列数，根据图片数量自动分布
     * @param imageCount 图片数量
     * @return 最佳列数
     */
    private fun getOptimalColumnsNumber(imageCount: Int): Int {
        return when (imageCount) {
            1 -> 1
            2 -> 2
            3 -> 3
            4 -> 2
            in 5..9 -> 3
            else -> 3 // 默认返回 3 列
        }
    }

    /**
     * 设置加载中的占位符号
     */
    fun setImageLoading(drawable: Drawable?) {
        this.imageLoading = drawable
    }

    /**
     * 设置加载失败的情况
     */
    fun setImageLoadedError(drawable: Drawable?) {
        this.imageLoadedError = drawable
    }

    /**
     * 设置点击事件监听器
     * @param clickListener 点击事件回调
     */
    fun setItemImageOnClickListener(
        clickListener: (position: Int, url: String) -> Unit
    ) {
        val currentAdapter = adapter as? ImageGridAdapter
        currentAdapter?.let {
            it.listener = object : OnImageClickListener {
                override fun onImageClick(position: Int, imageUrl: String) {
                    clickListener(position, imageUrl)
                }
            }
        }
    }
    // 定义接口处理点击事件
    interface OnImageClickListener {
        fun onImageClick(position: Int, imageUrl: String)
    }
}

