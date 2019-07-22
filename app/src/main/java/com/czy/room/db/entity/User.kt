package com.czy.room.db.entity

import androidx.room.*
import com.czy.room.db.converter.StringConverter

@Entity(indices = arrayOf(Index(value = arrayOf("name"),unique = true)))
@TypeConverters(StringConverter::class)
data class User(
    @PrimaryKey(autoGenerate = true) val _id:Int=0,
    val name:String,
    val age:Int,
    val likes:List<String>?
)