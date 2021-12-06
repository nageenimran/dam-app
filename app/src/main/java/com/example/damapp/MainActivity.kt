package com.example.damapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectXML()
    }

    private lateinit var create_acc_txt:TextView
    private lateinit var login_txt:TextView
    private fun connectXML() {
        try {

            create_acc_txt = findViewById(R.id.create_acc_id)
            create_acc_txt.setOnClickListener {
                move_to_create_acc_page()
            }
            login_txt = findViewById(R.id.login_id)
            login_txt.setOnClickListener {
                move_to_login_page()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Error:${ex.message.toString()}", Toast.LENGTH_LONG).show()
        }
    }

    private fun move_to_login_page() {
        try {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Error:${ex.message.toString()}", Toast.LENGTH_LONG).show()
        }
    }

    private fun move_to_create_acc_page() {
        try {
            startActivity(Intent(this,CreateAccount::class.java))
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Error:${ex.message.toString()}", Toast.LENGTH_LONG).show()
        }
    }

}