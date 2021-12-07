package com.example.damapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity() {

    private lateinit var float_btn:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        connectXML()
    }

    private fun connectXML() {
        float_btn=findViewById(R.id.floating_btn)
        float_btn.setOnClickListener {
            add_activity_btn()
        }
    }

    private fun add_activity_btn() {
        startActivity(Intent(this,AddActivity::class.java))
    }


}