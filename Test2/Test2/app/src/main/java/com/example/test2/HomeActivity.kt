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
                    " ??? ?????? ?????? ??????????????? ?????????????????????. ?????? ????????? ?????? ?????? ?????? ?????????????????? ?????? ?????? ?????????????????????. "))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "?????? ????????? ?????? 5??? ????????? ??????????????????? @here"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "????????? ???????????????? ?????? ?????? ??? ??????????????????."))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "????????? ?????? ?????? ???????????????. ????????? ????????? ????????? ????????? ??? ??? ????????????. ?????? ?????? ?????? ????????? ???????????????. "))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "?????? ?????? ????????? ????????? ??????????????? ?????? ????????????, ?????? ??????????????????!"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "??? ??????????????????. ????????????????????? ???????????? ???????????? ??????????????? @Arthur Kim ?????????"))
            add(
                Item(
                    R.drawable.ic_icon_account3,
                    R.drawable.ic__slack_icon,
                    "Slack",
                    "???! ?????? ?????? ?????? ??? ???????????? ????????? ????????????. ?????? ??? ???????????? ????????????!"))
        }
    }
}