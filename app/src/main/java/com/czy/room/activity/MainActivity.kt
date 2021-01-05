package com.czy.room.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.czy.room.R
import com.czy.room.db.AppDataBase
import com.czy.room.db.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_insert.setOnClickListener {
            thread {
                val list = ArrayList<String>()
                list.add("1111")
                list.add("2222")
                AppDataBase.getInstance(this).getUserDao()
                    .insert(User(name = "张三" + System.currentTimeMillis(), age = 22, likes = list))
            }
        }

        btn_query.setOnClickListener {
            thread {
                val list = AppDataBase.getInstance(this).getUserDao().queryAll()
                val stringBuilder = StringBuilder()
                for (it in list) {
                    stringBuilder.append("_id=${it._id},name=${it.name},age=${it.age}\n")
                }

                runOnUiThread {
                    tv_result.text = stringBuilder
                }

            }
        }

    }
}

inline fun log(msg: Any) {
    Log.d("DeBug", msg.toString())
}