package com.gmail.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var ostlist = ArrayList<Post>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.re)

        Thread{

            val url = URL("https://jsonplaceholder.typicode.com/posts?_limit=100")
            val jsonReader = url.readText()

            val gson = Gson()
            val a : List<Post> = gson.fromJson(jsonReader,Array<Post>::class.java).toList()

            runOnUiThread {
                for (i in a){
                    ostlist.add(Post(i.id,i.title))
                }
                val adapter = OstAdapter(ostlist)
                val linearLayoutManager = LinearLayoutManager(this)
                recyclerView.layoutManager = linearLayoutManager
                recyclerView.adapter = adapter
            }

        }.start()

    }
}

data class Post(val id:Int,val title:String)