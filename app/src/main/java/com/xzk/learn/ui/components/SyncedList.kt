package com.xzk.learn.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xzk.learn.entry.Category
import com.xzk.learn.entry.Item

// LazyColumn == RecyclerView
@Composable
fun MyLazyList(
    categories: List<Category>,
    listState: LazyListState = rememberLazyListState(),
    callback: (item: Item) -> Unit
) {
    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(categories) { _, category ->
            ItemCategory(category, callback)
        }
    }
}

@Composable
@Preview
fun SyncedLazyListPreview() {
    MyLazyList(
        listOf(
            Category(
                "Category 1"
            ),
            Category(
                "Category 2"
            ),
        ),
        rememberLazyListState()
    ) {

    }
}