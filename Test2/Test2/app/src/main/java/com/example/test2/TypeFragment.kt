package com.example.test2

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout

class TypeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_type,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemRV = getView()?.findViewById<RecyclerView>(R.id.item_recyclerview)
        with(itemRV) {
            this?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this?.adapter = RecyclerViewAdapter(itemData())

        }
    }

    private fun itemData(): MutableList<Item> {
        val list = mutableListOf<Item>()
        return list.apply {
            add(
                Item(
                    R.drawable.ic_profile01,
                    "홍길동",
                    R.drawable.ic__slack_icon,
                    "slack",
                    "안녕하세요 안드로이드 개발팀입니다. 현재까지 완료된 작업 업데이트 부탁드리겠습니다. 감사합니다."))
            add(
                Item(
                    R.drawable.ic_profile02,
                    "유관순",
                    R.drawable.ic_figma_lcon,
                    "figma",
                    "디자인 결과물 공유드립니다. 확인하시고 결제부탁드립니다."))
            add(
                Item(
                    R.drawable.ic_profile03,
                    "이순신",
                    R.drawable.ic_github_icon,
                    "github",
                    "개발자료 보내드립니다. 회의시간에 늦지 않게 해주세요."))
        }
    }
}