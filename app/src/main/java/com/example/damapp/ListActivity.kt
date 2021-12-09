package com.example.damapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.damapp.CustomAdaptors.CustomArrayAdaptor
import com.example.damapp.CustomAdaptors.DailyActivity
import com.example.damapp.databinding.ActivityListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class ListActivity : AppCompatActivity() {
    private lateinit var custom_list_page_binding_object:ActivityListBinding
    private lateinit var float_btn: FloatingActionButton
    private lateinit var logout_txt:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        custom_list_page_binding_object= ActivityListBinding.inflate(layoutInflater)
        setContentView(custom_list_page_binding_object.root)

        connectXML()
        create_player_object()
    }

    private fun connectXML() {
        float_btn=findViewById(R.id.floating_btn)
        float_btn.setOnClickListener{
            startActivity(Intent(this,AddActivity::class.java))

        }
        logout_txt=findViewById(R.id.logout_id)
        logout_txt.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
    private fun create_player_object()
    {
        try {
            var obj_babar_azam=DailyActivity("Babar Azam","Right Hand Batsman",R.drawable.babar_azam)
            var obj_hassan_ali=DailyActivity("Hassan Ali","Left Hand Batsman",R.drawable.hassan_ali)
            var obj_shaheen_afridi=DailyActivity("Shaheen Shah Afridi","Right Hand Batsman",R.drawable.shaheen_afridi)
            var obj_wahab_riaz=DailyActivity("Wahab Riaz","Left Hand Batsman",R.drawable.wahab_riaz)
            var list_of_players = listOf<DailyActivity>(obj_babar_azam,obj_hassan_ali,obj_shaheen_afridi,obj_wahab_riaz,obj_babar_azam,obj_hassan_ali,obj_shaheen_afridi,obj_wahab_riaz)
            custom_list_page_binding_object.listViewIdMain.adapter=CustomArrayAdaptor(ListActivity@this,list_of_players)
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"logical error:$(ex:message)",Toast.LENGTH_LONG).show()
        }
    }

}