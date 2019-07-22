package com.czy.room.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.czy.room.R
import com.czy.room.db.AppDataBase
import com.czy.room.db.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_insert.setOnClickListener {
            thread {
                val list = ArrayList<String>()
                list.add("1111")
                list.add("2222")
                AppDataBase.getInstance(this).getUserDao().insert(User(name = "张三",age = 22,likes = list))
            }
        }

        btn_query.setOnClickListener {
            thread {
                val list = AppDataBase.getInstance(this).getUserDao().queryAll()
                for (it in list){
                    log("_id=${it._id},name=${it.name},age=${it.age}")
                }
            }
        }

    }
}
inline fun log(msg:Any){
    Log.d("DeBug",msg.toString())
}