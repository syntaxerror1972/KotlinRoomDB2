package com.syntaxerror.kotlinroomdb2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB2.
 * Package Id : com.syntaxerror.kotlinroomdb2.data.model
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

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val userName:String,
    val email:String,
    val mobile:String,
    val city: String
    )
