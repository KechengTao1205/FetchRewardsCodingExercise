package com.example.fetchrewardscodingexercise.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fetchrewardscodingexercise.domain.FetchApi
import com.example.fetchrewardscodingexercise.domain.FetchApiClient
import com.example.fetchrewardscodingexercise.model.FetchItem
import com.example.fetchrewardscodingexercise.presentation.MainUiState
import com.example.fetchrewardscodingexercise.presentation.UIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchApi: FetchApi = FetchApiClient.fetchApi
) : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val _uiState = MutableStateFlow(MainUiState())

    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        getFetchItems()
    }

    /**
     * getFetchItems
     *
     * Description:
     *      - Use fetch api to get list of fetch item
     */
    fun getFetchItems() {
        ioScope.launch {
            try {
                val response = fetchApi.getFetchItems()
                _uiState.update {
                    it.copy(
                        fetchItems = formatValidFetchItemList(response),
                        state = UIState.LOADED
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        fetchItems = listOf(),
                        state = UIState.ERROR
                    )
                }
                Log.e(TAG, "Cause: ${e.cause}, Message: ${e.message}")
            }
        }
    }

    /**
     * formatValidFetchItemList
     *
     * Description:
     *      - get raw data from server, filter out null and empty items and group them by list id
     */
    private fun formatValidFetchItemList(list: List<FetchItem>): List<List<FetchItem>> {
        val filterList = list.filter {
            !it.name.isNullOrEmpty() && it.name.isNotBlank()
        }
        val groupedList = filterList.sortedBy {
            it.listId
        }.groupBy {
            it.listId
        }.values.toList()

        val validList = groupedList.map {
            it.sortedBy { item ->
                item.id
            }
        }
        return validList
    }
}