package com.example.damapp.CustomAdaptors

class DailyActivity (title:String,desc:String,actImg:Int){
    private var a_title=title
    private var a_desc=desc
    private var a_img=actImg

    fun get_aTitle():String
    {
        return a_title
    }
    fun get_aDesc():String
    {
        return a_desc
    }
    fun get_aImg():Int
    {
        return a_img
    }
}