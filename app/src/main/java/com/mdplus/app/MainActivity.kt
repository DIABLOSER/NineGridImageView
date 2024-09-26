package com.mdplus.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mdplus.app.databinding.ActivityMainBinding
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var dataList:MutableList<Post> = mutableListOf()
    private val adapter by lazy {
        PostAdapter(this,dataList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.recyclerView.adapter=adapter

        getData()
    }

    //模拟加载数据
    fun getData() {
        val inputStream = resources.openRawResource(R.raw.data)  // 从 res/raw 读取 JSON 文件
        val reader = InputStreamReader(inputStream)

        val gson = Gson()
        // 使用 TypeToken 来指定解析成 List<Post> 的类型
        val listType = object : TypeToken<List<Post>>() {}.type
        dataList.addAll(gson.fromJson(reader, listType))
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about -> {
                // 处理设置点击事件
                true
            }
            R.id.a -> {
                // 处理关于点击事件
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}