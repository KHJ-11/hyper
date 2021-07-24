package com.example.test2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.databinding.FragmentTypeBinding

class TypeFragment : Fragment() {

    private lateinit var binding: FragmentTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTypeBinding.inflate(layoutInflater)

        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        with(binding.itemRecyclerview) {
            layoutManager = manager
            adapter = RecyclerViewAdapter(itemData())
        }

        return binding.root
    }

    private fun itemData(): MutableList<ItemData> {
        val itemData = mutableListOf<ItemData>()
        itemData.add(
            ItemData(
                R.drawable.ic_profile01,
                "홍길동",
                R.drawable.ic__slack_icon,
                "slack",
                "안녕하세요 안드로이드 개발팀입니다. 현재까지 완료된 작업 업데이트 부탁드리겠습니다. 감사합니다."
            )
        )
        return itemData
    }
}