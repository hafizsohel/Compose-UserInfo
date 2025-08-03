package com.example.composeuserdemo.repository

import android.util.Log
import com.example.composeuserdemo.api.UserApi
import com.example.composeuserdemo.model.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi){

    //Only Repository can change data
    private val _category = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> get() = _category

    private val _users = MutableStateFlow<List<Users>>(emptyList())
    val users: StateFlow<List<Users>> get() = _users


    suspend fun getCategories(){
        val response = userApi.getCategories()
        if (response.isSuccessful &&response.body() !=null){
        _category.emit(response.body()!!)
        }
    }

    suspend fun getUsers(category: String){
        val response = userApi.getUsers("users[?(@.category==\"$category\")]")
        if (response.isSuccessful &&response.body() !=null){
            _users.emit(response.body()!!)
            Log.d("getUsers", response.body().toString())
        }
    }
}
