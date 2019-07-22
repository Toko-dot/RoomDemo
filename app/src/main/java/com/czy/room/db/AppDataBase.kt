package com.czy.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.czy.room.db.dao.UserDao
import com.czy.room.db.entity.User

@Database(entities = arrayOf(User::class),version = 3)
abstract class AppDataBase :RoomDatabase(){

    abstract fun getUserDao():UserDao


    companion object{
        private var instance:AppDataBase?=null

        fun getInstance(context: Context):AppDataBase{
            if (instance==null){
                synchronized(AppDataBase::class){
                    if (instance==null){
                        instance=Room.databaseBuilder(context,AppDataBase::class.java,"room")
                            .addMigrations(object :Migration(1,2){
                                override fun migrate(database: SupportSQLiteDatabase) {
                                    database.run {
                                        execSQL("alter table User add COLUMN likes TEXT")
                                    }
                                }

                            },object :Migration(2,3){
                                override fun migrate(database: SupportSQLiteDatabase) {
                                    database.run {
                                        execSQL("create UNIQUE index index_User_name on User(name)")
                                    }
                                }

                            })
                            .build()
                    }
                }
            }
            return instance!!
        }

    }
}