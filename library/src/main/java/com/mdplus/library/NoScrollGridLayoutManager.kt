package com.mdplus.library

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

/**
 *作者：daboluo on 2024/9/14 16:01
 *Email:daboluo719@gmail.com
 * 设置不能滚动
 */
class NoScrollGridLayoutManager(context: Context, spanCount: Int) : GridLayoutManager(context, spanCount) {
    override fun canScrollVertically(): Boolean {
        return false // 禁止竖向滚动
    }
    override fun canScrollHorizontally(): Boolean {
        return false // 禁止横向滚动
    }
}
