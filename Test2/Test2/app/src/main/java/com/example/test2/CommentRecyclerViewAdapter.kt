package com.example.test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentRecyclerViewAdapter(
    private val commentList: MutableList<Comment>)
    : RecyclerView.Adapter<CommentRecyclerViewAdapter.CommentHolder>() {

    inner class CommentHolder(rowRoot: View) : RecyclerView.ViewHolder(rowRoot) {
        val commentIV : ImageView = rowRoot.findViewById(R.id.comment_image)
        val commentTV : TextView = rowRoot.findViewById(R.id.comment_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentRecyclerViewAdapter.CommentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentHolder(view)
    }

    override fun onBindViewHolder(holder: CommentRecyclerViewAdapter.CommentHolder, position: Int) {
        val commentData = commentList[position]
        with(holder) {
            commentIV.setImageResource(commentData.commentImage)
            commentTV.text = commentData.commentText
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}