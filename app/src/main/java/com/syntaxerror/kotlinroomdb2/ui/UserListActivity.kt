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

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syntaxerror.kotlinroomdb2.data.db.UserDB
import com.syntaxerror.kotlinroomdb2.R
import com.syntaxerror.kotlinroomdb2.data.model.User

class UserListActivity : AppCompatActivity() {
    lateinit var database : UserDB
    private val userList = ArrayList<User>()
    lateinit var userAdapter : UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val actionbar = supportActionBar
        actionbar!!.title = "User List"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val recyclerView: RecyclerView = findViewById(R.id.userList)
        userAdapter = UserAdapter(userList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = userAdapter

        database = UserDB.getDatabaseInstance(this)
        database.userDAO().getUserList().observe(this, Observer {
            var sb = StringBuilder()
            sb.append("")
            it.forEach {
                var userObj = User(0,it.userName.toString(),
                    it.email.toString(),
                    it.mobile.toString(),
                    it.city.toString())
                userList.add(userObj)
            }
            userAdapter.notifyDataSetChanged()

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}