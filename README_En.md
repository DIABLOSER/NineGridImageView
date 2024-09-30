
# NineGridImageView

[![](https://jitpack.io/v/DIABLOSER/NineGridImageView.svg)](https://jitpack.io/#DIABLOSER/NineGridImageView)

# Screenshot effect
![截图效果](https://github.com/DIABLOSER/NineGridImageView/blob/main/Screen_recording_20240927_002157.gif)

# Function description

NineGridImageView is a nine-grid image library based on RecyclerView. Of course, NineGridImageView not only supports "nine-grid layout", but also supports "four-grid layout", etc., which is very convenient to use. If you like it, please submit Issues.

# Access documents

__Step 1.__ Add this to repositories at the end of your root build.gradle file：
```
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```
__Step 2.__ Add dependencies：
```
dependencies {
	implementation 'com.github.DIABLOSER:ZsmGridImageView:1.0.1'
}
```
__Step 3.__ In your xml file add：
```
<com.mdplus.nineGridImageView.NineGridImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/nineGridImageView"/>
```
__Step 4.__ Add in your Activity/Fragment/Adapter：
```
//Set up automatic distribution
nineGridImageView.setAutoDistribution(true)
// Set image link array
nineGridImageView.setImageUrls(datasBean.imageUrl)
//click event
nineGridImageView.setItemImageOnClickListener { position, url ->
    // Handle click event
    Toast.makeText(mContext, "Clicked image at $position", Toast.LENGTH_SHORT).show()
}
```
