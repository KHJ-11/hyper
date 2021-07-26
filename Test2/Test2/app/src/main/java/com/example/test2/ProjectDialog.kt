package com.example.test2

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProjectDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.project_dialog)

        val editText = findViewById<EditText>(R.id.popup_edit)
        val ok = findViewById<TextView>(R.id.popup_ok)
        val cancel = findViewById<TextView>(R.id.popup_cancel)

        ok.setOnClickListener {
            
        }
    }
}