package com.example.damapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.damapp.CustomAdaptors.DailyActivity
import com.example.damapp.databinding.ActivityListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class ListActivity : AppCompatActivity() {

    private lateinit var float_btn:FloatingActionButton
    private lateinit var add_activity_page_binding_object: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(add_activity_page_binding_object.root)
        connectXML()
        create_act_obj()
    }

    private fun create_act_obj() {
        try {
            var obj_1=DailyActivity("Drink Water","Drink water after every 60mins",R.drawable.ic_launcher_background)
            var list_of_activity= listOf<DailyActivity>(obj_1)
        }
        catch (ex:Exception)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
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