package com.example.damapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.github.dhaval2404.imagepicker.ImagePicker

class AddActivity : AppCompatActivity() {

    private lateinit var choose_btn:Button
    private lateinit var image_tv:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        image_tv=findViewById(R.id.choose_img_tv)
        choose_btn=findViewById(R.id.choose_img_btn)
        choose_btn.setOnClickListener {
            ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop().start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Activity.RESULT_OK && requestCode== ImagePicker.REQUEST_CODE)
        {
            image_tv?.setImageURI(data?.data)
        }
    }
}