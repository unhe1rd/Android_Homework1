package com.example.homework1.mainModule.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    var itemsCount = mutableStateOf(1)

    fun onClickAction() {
        itemsCount.value += 1
    }
}