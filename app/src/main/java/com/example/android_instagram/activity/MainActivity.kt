package com.example.android_instagram.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_instagram.R
import com.example.android_instagram.adapter.FeedAdapter
import com.example.android_instagram.model.Feed
import com.example.android_instagram.model.Post
import com.example.android_instagram.model.Story

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllFeeds())
    }

    fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView!!.adapter = adapter
    }

    fun getAllFeeds(): ArrayList<Feed> {

        val stories: ArrayList<Story> = ArrayList<Story>()
        stories.add(Story(R.drawable.im_user_4, "Xurshid"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_1, "Firdavs"))
        stories.add(Story(R.drawable.im_user_4, "Xurshid"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_1, "Firdavs"))

        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Begzodbek", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Sherzodbek", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_4, "Firdavsbek", R.drawable.im_post_1)))

        return feeds;
    }
}