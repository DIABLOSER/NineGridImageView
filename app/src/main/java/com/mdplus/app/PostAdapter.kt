package com.mdplus.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mdplus.library.NineGridImageView
import de.hdodenhof.circleimageview.CircleImageView

/**
 *作者：daboluo on 2024/9/20 15:19
 *Email:daboluo719@gmail.com
 */
class PostAdapter(
    private val mContext: Context,
    private val mData: MutableList<Post>
) : RecyclerView.Adapter<PostAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_post, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val datasBean = mData[position]
        Glide.with(mContext).load(datasBean.avatar).into(holder.avatar)
        holder.username.text=datasBean.username
        holder.content.text =datasBean.content

        //设置自动分布
        holder.nineGridImageView.setAutoDistribution(true)
        // 设置图片链接数组
        holder.nineGridImageView.setImageUrls(datasBean.imageUrl)
        //点击事件
        holder.nineGridImageView.setItemImageOnClickListener { position, url ->
            // 处理单击事件
            Toast.makeText(mContext, "Clicked image at $position", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: CircleImageView =itemView.findViewById(R.id.avatar)
        val username:TextView=itemView.findViewById(R.id.username)
        val content: TextView = itemView.findViewById(R.id.content)
        val nineGridImageView: NineGridImageView =itemView.findViewById(R.id.nineGridImageView)
    }
}