package com.czy.room.db.dao

import androidx.room.*
import com.czy.room.db.converter.StringConverter
import com.czy.room.db.entity.User

@Dao
@TypeConverters(StringConverter::class)
interface UserDao {
    /**
     * 添加一个用户
     */
    @Insert
    fun insert(user: User)
    /**
     * 删除一个用户
     */
    @Delete
    fun delete(user:User)

    /**
     * 查询所用用户
     */
    @Query("select * from User")
    fun queryAll():List<User>

    @Query("update user set age = :age where name = :name")
    fun updateAgeByName(name:String,age:Int):Int

}