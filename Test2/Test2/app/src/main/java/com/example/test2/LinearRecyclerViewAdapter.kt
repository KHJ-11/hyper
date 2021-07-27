package com.example.test2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class LinearRecyclerViewAdapter(
    private val itemList : MutableList<Item>)
    : RecyclerView.Adapter<LinearRecyclerViewAdapter.ItemHolder>() {

    inner class ItemHolder(rowRoot: View) : RecyclerView.ViewHolder(rowRoot) {
        val itemIV : ImageView = rowRoot.findViewById(R.id.profile_image)
        val itemIV2 : ImageView = rowRoot.findViewById(R.id.tool_image)
        val itemTV2 : TextView = rowRoot.findViewById(R.id.tool_text)
        val itemText : TextView = rowRoot.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearRecyclerViewAdapter.ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.type_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: LinearRecyclerViewAdapter.ItemHolder, position: Int) {
        val itemData = itemList[position]
        with(holder) {
            itemIV.setImageResource(itemData.itemImage)
            itemIV2.setImageResource(itemData.itemToolImage)
            itemTV2.text = itemData.itemToolName
            itemText.text = itemData.itemText
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, TypeItemActivity::class.java)
            intent.putExtra("datail_IV", itemData.itemImage)
            intent.putExtra("detail_TV", itemData.itemText)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}