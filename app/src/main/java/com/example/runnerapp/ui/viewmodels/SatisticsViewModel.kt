package com.example.runnerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runnerapp.repositories.MainRepositories

class SatisticsViewModel @ViewModelInject constructor(
    val mainRepositories: MainRepositories
) : ViewModel() {

}