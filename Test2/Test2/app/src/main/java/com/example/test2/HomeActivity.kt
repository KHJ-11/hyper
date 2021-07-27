package com.example.test2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {
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
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawLayout_main)
        when(item.itemId) {
            R.id.logout -> {
                finish()
            }
            R.id.sideMenu -> {
                drawerLayout.openDrawer(GravityCompat.END)
            }
            R.id.newtask -> {
                val builder = AlertDialog.Builder(this)
                val popopTask = layoutInflater.inflate(R.layout.type_dialog, null)
                with(builder) {
                    setView(popopTask).show()
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
}