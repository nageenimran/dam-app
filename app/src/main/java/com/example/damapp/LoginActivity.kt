package com.example.damapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        connectXML()


    }

    private lateinit var email_et:EditText
    private lateinit var password_et:EditText
    private lateinit var login_btn: Button

    private fun connectXML() {
        email_et=findViewById(R.id.email_edit_text)
        password_et=findViewById(R.id.password_edit_text)
        login_btn=findViewById(R.id.login_btn)
        login_btn.setOnClickListener{
            login_btn_fun()
        }
    }

    private fun login_btn_fun() {
        if(email_et.text.isBlank())
        {
            Toast.makeText(this,getString(R.string.warning),
                Toast.LENGTH_LONG).show()
            email_et.requestFocus()
        }
        else if (password_et.text.isBlank()) {
            Toast.makeText(this,getString(R.string.warning),
                Toast.LENGTH_LONG).show()
            password_et.requestFocus()
        }

        if(email_et.text.isNotBlank() && password_et.text.isNotBlank())
        {
            var helper= DBHelper(applicationContext)
            var db=helper.readableDatabase
            var args= listOf<String>(email_et.text.toString(),password_et.text.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM USERS WHERE EMAIL = ? AND PASS = ?",args)
            if(rs.moveToNext()){
                startActivity(Intent(this,ListActivity::class.java))
                email_et.text.clear()
                password_et.text.clear()
            }
            else{
                Toast.makeText(applicationContext, "Invalid Credential", Toast.LENGTH_SHORT).show()
                email_et.text.clear()
                password_et.text.clear()
                email_et.requestFocus()

            }
        }
    }
}