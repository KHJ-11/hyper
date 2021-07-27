package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.databinding.ActivityTypeItemBinding
import okhttp3.internal.notify

class TypeItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTypeItemBinding
    val list = mutableListOf<Comment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTypeItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            setSupportActionBar(toolbar2)
            with(supportActionBar) {
                this!!.setDisplayHomeAsUpEnabled(true)
                this!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
                this!!.setDisplayShowTitleEnabled(false)
            }
        }

        binding.apply {
            detailText.text = intent.getStringExtra("detail_TV")
        }

        binding.commentRV.apply {
            layoutManager =
                LinearLayoutManager(this@TypeItemActivity, LinearLayoutManager.VERTICAL, false)
            adapter = CommentRecyclerViewAdapter(commentData())
        }

        binding.commentButton.setOnClickListener {
            list.add(Comment(R.drawable.ic_account_circle_128_28129,"${binding.commentEditText.text.toString()}"))
            binding.commentRV.adapter?.notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val back = item.itemId
        when(back) {
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun commentData() : MutableList<Comment> {
        return list.apply {
            add(Comment(R.drawable.ic_account_circle_128_28129, "네"))
        }
    }
}