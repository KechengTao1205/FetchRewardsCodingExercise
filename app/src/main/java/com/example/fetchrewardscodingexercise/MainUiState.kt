package com.example.fetchrewardscodingexercise

data class MainUiState(
    val fetchItems: List<List<FetchItem>> = listOf(),
    val state: UIState = UIState.LOADING
)

enum class UIState {
    LOADING,
    LOADED,
    ERROR
}