package com.xzk.learn.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ahmadhamwi.tabsync_compose.lazyListTabSync
import com.xzk.learn.entry.Category
import com.xzk.learn.entry.Item

@Composable
fun TabSyncComposeScreen(categories: List<Category>,  callback: (item: Item) -> Unit) {
    val (selectedTabIndex, setSelectedTabIndex, listState) = lazyListTabSync(categories.indices.toList())
    // Column  == LinearLayout.Vertical
    Column {
        MyTabBar(
            categories = categories,
            selectedTabIndex = selectedTabIndex,
            onTabClicked = { index, _ -> setSelectedTabIndex(index) }
        )

        MyLazyList(categories, listState,callback)
    }
}



