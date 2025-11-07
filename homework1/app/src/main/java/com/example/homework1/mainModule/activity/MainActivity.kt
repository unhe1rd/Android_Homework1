package com.example.homework1.mainModule.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.homework1.mainModule.layout.MainScreen
import com.example.homework1.mainModule.viewModel.MainViewModel
import com.example.homework1.ui.theme.Homework1Theme

class MainActivity : ComponentActivity() {
    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homework1Theme {
                MainScreen(viewModel)
            }
        }
    }
}