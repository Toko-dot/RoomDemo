package com.czy.room.db.converter

import android.text.TextUtils
import androidx.room.TypeConverter
import com.czy.room.activity.log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.StringBuilder

class StringConverter {
    @TypeConverter
    fun listTostring(list:List<String>):String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun stringTolist(str:String?):List<String>?{
        return Gson().fromJson<List<String>>(str, object : TypeToken<List<String>>() {

        }.type)
    }
}