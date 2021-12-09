package com.example.damapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.damapp.CustomAdaptors.CustomArrayAdaptor
import com.example.damapp.CustomAdaptors.DailyActivity
import com.example.damapp.databinding.ActivityListBinding
import java.lang.Exception

class AddActivity : AppCompatActivity() {

    private lateinit var choose_img_btn:Button
    private lateinit var title_et:EditText
    private lateinit var desc_et:EditText

    private lateinit var add_activity_btn:Button
    private lateinit var logout_txt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        connectXML()
    }

    private fun connectXML() {
        choose_img_btn=findViewById(R.id.choose_img_btn)
        title_et=findViewById(R.id.email_edit_text)
        desc_et=findViewById(R.id.password_edit_text)
        add_activity_btn=findViewById(R.id.add_activity_btn)
        add_activity_btn.setOnClickListener {
               on_click_add_activity()
        }
        logout_txt=findViewById(R.id.logout_id)
        logout_txt.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    private fun on_click_add_activity() {
        var helper = DBHelper (applicationContext)
        var db = helper.readableDatabase
        var cv= ContentValues()
        if (title_et.text.isBlank()) {
            title_et.error="Title cannot be empty"
            title_et.requestFocus()
        }

        else if (desc_et.text.isBlank()) {
            desc_et.error="Description cannot be Empty"
            desc_et.requestFocus()
        }

        if(title_et.text.isNotBlank())
        {
            cv.put("TITLE", title_et.text.toString())


        }
        if(desc_et.text.isNotBlank())
        {
            cv.put("DES", desc_et.text.toString())
        }
        db.insert("ACTIVITY",null,cv)
    }

}