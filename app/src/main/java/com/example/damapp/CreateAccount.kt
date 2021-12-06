package com.example.damapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.example.damapp.databinding.ActivityCreateAccountBinding
import java.lang.Exception

class CreateAccount : AppCompatActivity() {

    private lateinit var custom_list_page_binding_object:ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        custom_list_page_binding_object= ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(custom_list_page_binding_object.root)




        connectXML()
    }

    private lateinit var name_et:EditText
    private lateinit var email_et:EditText
    private lateinit var dob_et:EditText
    private lateinit var password_et:EditText
    private lateinit var address_et:EditText
    private lateinit var signup_btn:Button


    private fun connectXML() {
        try {
            name_et=findViewById(R.id.name_edit_text)
            email_et=findViewById(R.id.email_edit_text)
            dob_et=findViewById(R.id.dob_edit_text)
            password_et=findViewById(R.id.password_edit_text)
            address_et=findViewById(R.id.address_edit_text)
            signup_btn=findViewById(R.id.sign_up_btn)
            signup_btn.setOnClickListener{
                sign_up_btn_fun()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(this, "Error:${ex.message.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sign_up_btn_fun() {
        try {
            var helper = DBHelper (applicationContext)
            var db = helper.readableDatabase
            var cv=ContentValues()
            var rs=db. rawQuery ("SELECT * FROM USERS" , null)
            //if(rs.moveToNext () )
                //Toast.makeText (applicationContext,rs.getString (1) , Toast. LENGTH_LONG).show()

            if (name_et.text.isBlank()) {
                name_et.error="Name cannot be empty"
                name_et.requestFocus()
            }

            else if (email_et.text.isBlank()) {
                email_et.error="Email cannot be Empty"
                email_et.requestFocus()
            }

            else if (dob_et.text.isBlank()) {
                dob_et.error="Date of Birth can't be Empty"
                dob_et.requestFocus()
            }

            else if (password_et.text.isBlank()) {
                password_et.error="Password cannot be Empty"
                password_et.requestFocus()
            }

            else if (address_et.text.isBlank()) {
                address_et.error="Address cannot be Empty"
                address_et.requestFocus()
            }

            if(name_et.text.isNotBlank())
            {
                cv.put("NAME", name_et.text.toString())


            }
            if(email_et.text.isNotBlank())
            {
                cv.put("EMAIL", email_et.text.toString())

            }
            if(dob_et.text.isNotBlank())
            {
                cv.put("DOB", dob_et.text.toString())

            }
            if(password_et.text.isNotBlank())
            {
                cv.put("PASS", password_et.text.toString())

            }
            if(address_et.text.isNotBlank())
            {
                cv.put("ADDRESS", address_et.text.toString())

            }
            db.insert("USERS",null,cv)
            if(name_et.text.isNotBlank() && email_et.text.isNotBlank() && dob_et.text.isNotBlank() && password_et.text.isNotBlank() && address_et.text.isNotBlank())
            {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(this, "Error:${ex.message.toString()}", Toast.LENGTH_SHORT).show()
        }
    }
}