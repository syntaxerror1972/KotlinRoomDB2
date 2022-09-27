package com.syntaxerror.kotlinroomdb2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.syntaxerror.kotlinroomdb2.R
import com.syntaxerror.kotlinroomdb2.data.model.User

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB2.
 * Package Id : com.syntaxerror.kotlinroomdb2.ui
 * Created By :  Shrawan Shinde
 * Created Date :  28,September,2022
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

class UserAdapter(private var usersList: List<User>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtUserName: TextView = view.findViewById(R.id.txtUserName)
        var txtEmail: TextView = view.findViewById(R.id.txtEmail)
        var txtMobile: TextView = view.findViewById(R.id.txtMobile)
        var txtCity: TextView = view.findViewById(R.id.txtCity)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = usersList[position]
        holder.txtUserName.text = "User Name : "+user.userName
        holder.txtEmail.text = "Email : "+user.email
        holder.txtMobile.text = "Mobile : "+user.mobile
        holder.txtCity.text = "City : "+user.city
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}