package com.syntaxerror.kotlinroomdb2.ui
/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB2.
 * Package Id : com.syntaxerror.kotlinroomdb2
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
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.syntaxerror.kotlinroomdb2.data.db.UserDB
import com.syntaxerror.kotlinroomdb2.data.model.User
import com.syntaxerror.kotlinroomdb2.R
import com.syntaxerror.kotlinroomdb2.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database : UserDB
    lateinit var dataBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        database = UserDB.getDatabaseInstance(this)
        getTotalUser()
    }

    fun getTotalUser(){
        database.userDAO().getUserList().observe(this, Observer {
            dataBinding.btnViewUser.setText("View Users("+it.count().toString()+")")
        })
    }

    fun viewUsers(view : View){
        startActivity(Intent(this, UserListActivity::class.java))
    }

    fun addUser(view : View){
        var userObj = User(0,dataBinding.edtUserName.text.toString(),dataBinding.edtEmail.text.toString(),dataBinding.edtMobile.text.toString(),dataBinding.edtCity.text.toString())
        GlobalScope.launch {
            database.userDAO().addUser(userObj)
            dataBinding.edtUserName.setText("")
            dataBinding.edtEmail.setText("")
            dataBinding.edtMobile.setText("")
            dataBinding.edtCity.setText("")
        }
        val toast = Toast.makeText(applicationContext, "User added successfully", Toast.LENGTH_LONG)
        toast.show()
    }

}