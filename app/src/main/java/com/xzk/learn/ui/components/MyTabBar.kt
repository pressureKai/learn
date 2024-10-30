package com.xzk.learn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xzk.learn.entry.Category

@Composable
fun MyTabBar(
    categories: List<Category>,
    selectedTabIndex: Int,
    onTabClicked: (index: Int, category: Category) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        indicator = { tabPositions ->
            //自定义指示器
            TabRowDefaults.SecondaryIndicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .clip(RoundedCornerShape(15.dp)),
                color = Color.Black
            )
        },
        modifier = Modifier.background(Color.White),
        edgePadding = 0.dp,
        containerColor = Color.White,
        divider = {
            HorizontalDivider(color = Color.White)
        }
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onTabClicked(index, category) },
                text = { Text(category.name.uppercase(), color = Color.Black) },
                modifier = Modifier.background(Color.White)
            )
        }
    }
}

@Composable
@Preview
fun SyncedTabBarPreview() {
    var selectedIndex by remember { mutableStateOf(0) }

    MyTabBar(
        categories = mutableListOf(
            Category("Home"),
        ),
        selectedTabIndex = selectedIndex
    ) { index, _ ->
        selectedIndex = index
    }
}