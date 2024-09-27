package com.mdplus.nineGridImageView

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

/**
 *作者：daboluo on 2024/9/14 15:20
 *Email:daboluo719@gmail.com
 */
class ImageGridAdapter(
    private val context: Context,
    private val imageUrls: List<String>,
    private var ImageLoading: Drawable? = null,
    private var ImageLoadedError: Drawable? = null
) : RecyclerView.Adapter<ImageGridAdapter.ImageViewHolder>() {

    var listener: NineGridImageView.OnImageClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        // 使用 Glide 加载图片
        Glide.with(context)
            .load(imageUrls[position])
            .placeholder(ImageLoading) // 加载中的占位图
            .error(ImageLoadedError) // 加载失败的占位图
            .into(holder.imageView)

        // 设置点击事件
        holder.imageView.setOnClickListener {
            listener?.onImageClick(position, imageUrls[position])
        }
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: SquareImageView = itemView.findViewById(R.id.imageView)
    }
}


