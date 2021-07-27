package com.example.test2

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test2.databinding.FragmentProjectBinding

class ProjectFragment : Fragment() {
    private var isFabOpen = false
    val list = mutableListOf<Project>()

    private lateinit var binding: FragmentProjectBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProjectBinding.inflate(layoutInflater)

        val manager = GridLayoutManager(context, 3)
        with(binding.projectRV) {
            layoutManager = manager
            adapter = GridRecyclerViewAdapter(projectData())
        }

        val dialogView = layoutInflater.inflate(R.layout.project_dialog, null)
        val dialogEditText = dialogView.findViewById<EditText>(R.id.popup_edit)
        val dialogCreate = dialogView.findViewById<TextView>(R.id.popup_ok)
        val dialogCancel = dialogView.findViewById<TextView>(R.id.popup_cancel)
        val builder = AlertDialog.Builder(context)

        binding.fab.setOnClickListener {
            anim()
        }
        binding.fabCreate.setOnClickListener {
            builder.setView(dialogView).show()
            dialogCreate.setOnClickListener {
                list.add(Project(R.drawable.ic_folder, "${dialogEditText.text.toString()}"))
                binding.projectRV.adapter?.notifyDataSetChanged()
                dialogEditText.text = null
            }
            dialogCancel.setOnClickListener {

            }
        }

        return binding.root
    }

    private fun anim() {
        val fab_open = AnimationUtils.loadAnimation(context, R.anim.fab_open)
        val fab_close = AnimationUtils.loadAnimation(context, R.anim.fab_close)

        binding.apply {
            if (isFabOpen) {
                fabCreate.startAnimation(fab_close)
                fabDelete.startAnimation(fab_close)
                fabCreate.isClickable = false
                fabDelete.isClickable = false
                isFabOpen = false
            } else {
                fabCreate.startAnimation(fab_open)
                fabDelete.startAnimation(fab_open)
                fabCreate.isClickable = true
                fabDelete.isClickable = true
                isFabOpen = true
            }
        }
    }

    private fun projectData() : MutableList<Project> {
        return list.apply {
            add(
                Project(R.drawable.ic_folder,
                "hyper")
            )
        }
    }
}