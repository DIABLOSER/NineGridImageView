package com.daboluo.app

/**
 *作者：daboluo on 2024/9/20 11:56
 *Email:daboluo719@gmail.com
 * 帖子对象
 */
data class Post(
    val username:String,//昵称
    val avatar:String,//头像()图片链接
    val content:String,//内容
    val imageUrl:List<String>//图片链接
)