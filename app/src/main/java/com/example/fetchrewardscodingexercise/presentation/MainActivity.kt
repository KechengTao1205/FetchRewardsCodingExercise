package com.example.fetchrewardscodingexercise.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchrewardscodingexercise.viewmodel.MainViewModel
import com.example.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel()
            val uiState = viewModel.uiState.collectAsState().value
            FetchRewardsCodingExerciseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when(uiState.state) {
                        UIState.LOADING -> {
                            MainScreen.LoadingScreen()
                        }
                        UIState.LOADED -> {
                            MainScreen.LoadedScreen(fetchItemsList = uiState.fetchItems)
                        }
                        UIState.ERROR -> {
                            MainScreen.ErrorScreen {
                                viewModel.getFetchItems()
                            }
                        }
                    }
                }
            }
        }
    }
}
