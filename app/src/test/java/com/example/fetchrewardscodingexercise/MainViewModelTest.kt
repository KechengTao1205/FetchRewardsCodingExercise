package com.example.fetchrewardscodingexercise

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@RunWith(MockitoJUnitRunner::class)
class MockedContextTest {

    private val fetchApi = mock<FetchApi>()
    private val mockedFetchItem = FetchItem(
        id = 0,
        listId = 1,
        name = "item 0"
    )
    private val mockedResponse: List<FetchItem> = listOf(
            mockedFetchItem
        )
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        fetchApi.stub {
            onBlocking {
                getFetchItems()
            }.doReturn(
                mockedResponse
            )
        }
        viewModel = MainViewModel(
            fetchApi = fetchApi
        )
    }

    @Test
    fun `getFetchItems() get correct data`() {
        runTest {
            assertEquals(UIState.LOADED, viewModel.uiState.value.state)
        }
    }
}
