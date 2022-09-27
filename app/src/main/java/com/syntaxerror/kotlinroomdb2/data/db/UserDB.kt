package com.syntaxerror.kotlinroomdb2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.syntaxerror.kotlinroomdb2.data.dao.UserDAO
import com.syntaxerror.kotlinroomdb2.data.model.User

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB2.
 * Package Id : com.syntaxerror.kotlinroomdb2.data.db
 * Created By :  Shrawan Shinde
 * Created Date :  27, September,2022
 *
 *** Contact Details ***
 *
 * Name : Shrawan B. Shinde
 * Email : syntaxerror1972@gmail.com
 * Github Link : https://github.com/syntaxerror1972/KotlinRoomDB2
 * LinkedIn Link : https://in.linkedin.com/in/shrawan-shinde-59ba57a1
 * Copyright (c) 2022. All rights reserved.
 *
 **************************************************************************************
 */

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDAO() : UserDAO

    companion object{
        @Volatile
        private var db_instance : UserDB? = null

        fun getDatabaseInstance(context: Context) : UserDB {
            if(db_instance==null){
                synchronized(this){
                    db_instance = Room.databaseBuilder(context.applicationContext,UserDB::class.java,"user").build()
                }
            }
            return db_instance!!
        }
    }
}