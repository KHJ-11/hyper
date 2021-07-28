package com.example.test2

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.CipherSuiteNotSupportedException
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {
    val list = mutableListOf<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.home_frame, TypeFragment()).commit()
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        with(supportActionBar) {
            this!!.setDisplayShowTitleEnabled(false)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navi)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.logout -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            R.id.sideMenu -> {
                val drawerLayout = findViewById<DrawerLayout>(R.id.drawLayout_main)
                drawerLayout.openDrawer(GravityCompat.END)
            }
            R.id.newtask -> {
                val itemRV = findViewById<RecyclerView>(R.id.item_recyclerview)
                with(itemRV) {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = LinearRecyclerViewAdapter(itemData())
                }

                val dialogView = layoutInflater.inflate(R.layout.type_dialog, null)
                val dialogEditText = dialogView.findViewById<EditText>(R.id.popup_edit2)
                val dialogCreate = dialogView.findViewById<TextView>(R.id.popup_ok2)
                val dialogCancel = dialogView.findViewById<TextView>(R.id.popup_cancel2)
                val builder = AlertDialog.Builder(this).create()
                builder.setView(dialogView)
                builder.show()

                dialogCreate.setOnClickListener {
                    list.add(Item(
                        R.drawable.ic_icon_account5,
                        R.drawable.logo2,
                        "Hyperinbox",
                        "${dialogEditText.text.toString()}"))
                    itemRV.adapter?.notifyDataSetChanged()
                    dialogEditText.text = null
                    builder.dismiss()
                }
                dialogCancel.setOnClickListener {
                    builder.dismiss()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home_type -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_frame, TypeFragment()).commit()
            }
            R.id.home_project -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_frame, ProjectFragment()).commit()
            }
            R.id.home_search -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_frame, SearchFragment()).commit()
            }
            R.id.home_my -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_frame, MyFragment()).commit()
            }
        }
        return true
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
                    "Slack",
                    "자리들 잡으셨나요? 미팅 링크 곧 공유드릴게요."))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "인프런 계정 정보 알려드려요. 계정이 두개니 하나씩 쓰시면 될 것 같습니다. 각자 어떤 계정 쓸건지 알려주세요. "))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "어제 외부 일정이 많아서 올려주신거 확인 못했는데, 오늘 확인해볼게요!"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "네 확인해볼게요. 업데이트하신거 있을때는 태그해서 불러주세요 @Arthur Kim 이렇게"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "네! 제가 어제 일이 좀 길어져서 확인을 못했어요. 오늘 중 업데이트 드릴게요!"))
        }
    }
}