package com.example.test2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {
    val list = mutableListOf<Item>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchRV = view.findViewById<RecyclerView>(R.id.searchRV)
        with(searchRV) {
            this?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this?.adapter = LinearRecyclerViewAdapter(itemData())
        }

        val searchEditText = view.findViewById<EditText>(R.id.search_editText)
        searchEditText.addTextChangedListener(object :TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (searchEditText.text.toString() == "네") {
                    searchRV.visibility = View.VISIBLE
                } else {
                    searchRV.visibility = View.INVISIBLE
                }
            }

        })
    }

    private fun itemData(): MutableList<Item> {
        return list.apply {
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    " 네 오늘 미팅 비대면으로 진행하겠습니다. 이따 오후에 미팅 링크 미리 전해드릴테니 접속 환경 점검해주시고요. "))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "slack",
                    "네 확인해볼게요. 업데이트하신거 있을때는 태그해서 불러주세요 @Arthur Kim 이렇게"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "slack",
                    "네! 제가 어제 일이 좀 길어져서 확인을 못했어요. 오늘 중 업데이트 드릴게요!"))
        }
    }
}