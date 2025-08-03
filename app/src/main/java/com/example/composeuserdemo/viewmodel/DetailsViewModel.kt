package com.example.composeuserdemo.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeuserdemo.model.Users
import com.example.composeuserdemo.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: UserRepository,
                                           private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val users: StateFlow<List<Users>> get() = repository.users

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category")?: "Admin"
            repository.getUsers(category)
            Log.d("DetailViewModel", users.value.toString())
        }
    }
}