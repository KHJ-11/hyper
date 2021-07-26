package com.example.test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridRecyclerViewAdapter(
    private val projectList: MutableList<Project>)
    : RecyclerView.Adapter<GridRecyclerViewAdapter.ProjectHolder>() {

    inner class ProjectHolder(rowRoot: View) : RecyclerView.ViewHolder(rowRoot) {
        val projectIV : ImageView = rowRoot.findViewById(R.id.folder_IV)
        val projectTV : TextView = rowRoot.findViewById(R.id.folder_TV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): GridRecyclerViewAdapter.ProjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_item,parent,false)
        return ProjectHolder(view)
    }

    override fun onBindViewHolder(holder: GridRecyclerViewAdapter.ProjectHolder, position: Int) {
        val projectData = projectList[position]
        with(holder) {
            projectIV.setImageResource(projectData.projectImage)
            projectTV.text = projectData.projectName
        }
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

}