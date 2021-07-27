package com.example.test2

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class TypeFragment : Fragment() {
    val list = mutableListOf<Item>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_type,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemRV = view.findViewById<RecyclerView>(R.id.item_recyclerview)
        with(itemRV) {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = LinearRecyclerViewAdapter(itemData())
        }
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
                    "Slack",
                    "오늘 미팅은 오후 5시 정도에 괜찮으신가요? @here"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "slack",
                    "자리들 잡으셨나요? 미팅 링크 곧 공유드릴게요."))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "slack",
                    "인프런 계정 정보 알려드려요. 계정이 두개니 하나씩 쓰시면 될 것 같습니다. 각자 어떤 계정 쓸건지 알려주세요. "))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "slack",
                    "어제 외부 일정이 많아서 올려주신거 확인 못했는데, 오늘 확인해볼게요!"))
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