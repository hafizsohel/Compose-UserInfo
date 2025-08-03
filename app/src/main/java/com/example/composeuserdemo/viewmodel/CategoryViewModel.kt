package com.example.composeuserdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeuserdemo.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val categories: StateFlow<List<String>> get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}