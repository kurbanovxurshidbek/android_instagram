package com.example.android_instagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_instagram.R
import com.example.android_instagram.model.Feed
import com.example.android_instagram.model.Story

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TYPE_ITEM_STORY = 0
        private val TYPE_ITEM_POST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].stories.size > 0) TYPE_ITEM_STORY else TYPE_ITEM_POST
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PosterViewHolder(view)
    }

    fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView!!.adapter = adapter
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.stories, recyclerView)
        }

        if (holder is PosterViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_photo = holder.iv_photo
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo.setImageResource(feed.post!!.photo)
            tv_fullname.text = feed.post!!.fullname
        }
    }

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.setLayoutManager(manager)
        }
    }

    class PosterViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ImageView
        var iv_photo: ImageView
        var iv_like: ImageView
        var iv_comment: ImageView
        var iv_send: ImageView
        var iv_save: ImageView
        var tv_fullname: TextView
        var tv_caption: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            iv_photo = view.findViewById(R.id.iv_photo)
            iv_like = view.findViewById(R.id.iv_like)
            iv_comment = view.findViewById(R.id.iv_comment)
            iv_send = view.findViewById(R.id.iv_send)
            iv_save = view.findViewById(R.id.iv_save)
            tv_caption = view.findViewById(R.id.tv_caption)
        }
    }
}