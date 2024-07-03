package com.example.fetchrewardscodingexercise.presentation

import com.example.fetchrewardscodingexercise.model.FetchItem

data class MainUiState(
    val fetchItems: List<List<FetchItem>> = listOf(),
    val state: UIState = UIState.LOADING
)

enum class UIState {
    LOADING,
    LOADED,
    ERROR
}