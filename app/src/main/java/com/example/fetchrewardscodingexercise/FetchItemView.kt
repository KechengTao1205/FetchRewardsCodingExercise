package com.example.fetchrewardscodingexercise


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun FetchItemView(
    listId: Int,
    fetchItemList: List<FetchItem>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "List ID - $listId",
                color = MaterialTheme.colorScheme.inversePrimary,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        LazyColumn(
            Modifier.height(20.dp * fetchItemList.size)
                .clip(RoundedCornerShape(8.dp))
        ) {
            items(fetchItemList) { item ->
                FetchItemDetails(fetchItem = item)
            }
        }
    }
}

@Composable
fun FetchItemDetails(fetchItem: FetchItem) {
    Box(
        modifier =
            Modifier.fillMaxWidth()
                .padding(start = 16.dp, bottom = 1.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.outlineVariant)
    ) {
       Text(
           modifier = Modifier.padding(start = 16.dp),
           text = fetchItem.name.toString(),
           style = MaterialTheme.typography.bodyLarge
       )
    }
}
