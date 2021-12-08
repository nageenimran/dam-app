package com.example.damapp.CustomAdaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.damapp.R

class CustomArrayAdaptor(context:Context,var actdata:List<DailyActivity>):ArrayAdapter<DailyActivity>(context,
    R.layout.custom_row_for_activity,actdata) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var single_row=LayoutInflater.from(context).inflate(R.layout.custom_row_for_activity,null,true)
        var name_of_act:TextView=single_row.findViewById(R.id.custom_title_txt)
        var desc_of_act:TextView=single_row.findViewById(R.id.custom_des_txt)
        var img_of_act:ImageView=single_row.findViewById(R.id.custom_img_tv)

        name_of_act.text=actdata.get(position).get_aTitle()
        desc_of_act.text=actdata.get(position).get_aDesc()
        img_of_act.setImageResource(actdata.get(position).get_aImg())

        return single_row
    }

}