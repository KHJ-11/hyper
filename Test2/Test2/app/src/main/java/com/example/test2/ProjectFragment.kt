package com.example.test2

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test2.databinding.FragmentProjectBinding

class ProjectFragment : Fragment(), View.OnClickListener {

    private var isFabOpen = false

    private lateinit var binding: FragmentProjectBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProjectBinding.inflate(layoutInflater)

        val manager = GridLayoutManager(context, 3)
        with(binding.projectRV) {
            layoutManager = manager
            adapter = GridRecyclerViewAdapter(projectData())
        }

        binding.apply {
            fab.setOnClickListener(this@ProjectFragment)
            fabCreate.setOnClickListener(this@ProjectFragment)
            fabDelete.setOnClickListener(this@ProjectFragment)
        }

        return binding.root
    }

    override fun onClick(v: View?) {
        binding.apply {
            when(v?.id) {
                fab.id -> {
                    anim()
                }
                fabCreate.id -> {
                    val builder = AlertDialog.Builder(context)
                    val popupView = layoutInflater.inflate(R.layout.project_dialog, null)
                    with(builder) {
                        setView(popupView)
                        show()
                    }
                }
                fabDelete.id -> {

                }
            }
        }
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
        val list = mutableListOf<Project>()
        return list.apply {
            add(
                Project(R.drawable.ic_folder,
                "hyper")
            )
        }
    }
}