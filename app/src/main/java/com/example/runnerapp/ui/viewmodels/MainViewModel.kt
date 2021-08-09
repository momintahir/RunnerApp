package com.example.runnerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runnerapp.repositories.MainRepositories

class MainViewModel @ViewModelInject constructor(
    val mainRepositories: MainRepositories
) : ViewModel() {

}