package com.example.fetchrewardscodingexercise.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.model.FetchItem
import com.example.fetchrewardscodingexercise.presentation.fetchitem.FetchItemView

object MainScreen {
    @Composable
    fun LoadedScreen(
        fetchItemsList: List<List<FetchItem>>
    ) {
        if (fetchItemsList.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.empty_list_item_message),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                items(fetchItemsList) {
                    FetchItemView(listId = it.first().listId, fetchItemList = it)
                }
            }
        }
    }

    @Composable
    fun LoadingScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
            Text(
                text = stringResource(id = R.string.loading_list_message),
            )
        }
    }

    @Composable
    fun ErrorScreen(
        onConfirmation: () -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AlertDialog(
                onDismissRequest = { },
                confirmButton = {
                    Button(
                        onClick = {
                            onConfirmation()
                        }
                    ) {
                        Text(text = stringResource(id = R.string.error_message_retry))
                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Icon Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                },
                title = {
                    Text(text = stringResource(id = R.string.error_message_header))
                },
                text = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.error_message),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    }
}