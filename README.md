# NineGridImageView

[![](https://jitpack.io/v/DIABLOSER/NineGridImageView.svg)](https://jitpack.io/#DIABLOSER/NineGridImageView)

# 截图效果
![截图效果](https://github.com/DIABLOSER/NineGridImageView/blob/main/Screen_recording_20240927_002157.gif)

# 功能描述 Function description

NineGridImageView是一个基于RecyclerView实现的九宫格图片的库，当然了，NineGridImageView不仅仅支持“九宫格布局”，还支持“四宫格”等，使用起来非常方便。如果喜欢的话，欢迎提Issues。

# 接入文档 Access documents

__Step 1.__ 在你的根 build.gradle 文件末尾添加它到 repositories 中：
```
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```
__Step 2.__ 添加依赖：
```
dependencies {
	implementation 'com.github.DIABLOSER:ZsmGridImageView:1.0.1'
}
```
__Step 3.__ 在你的xml文件中添加：
```
<com.mdplus.nineGridImageView.NineGridImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/nineGridImageView"/>
```
__Step 4.__ 在你的Activity/Fragment/Adapter中添加：
```
//设置自动分布
nineGridImageView.setAutoDistribution(true)
// 设置图片链接数组
nineGridImageView.setImageUrls(datasBean.imageUrl)
//点击事件
nineGridImageView.setItemImageOnClickListener { position, url ->
    // 处理单击事件
    Toast.makeText(mContext, "Clicked image at $position", Toast.LENGTH_SHORT).show()
}
```
