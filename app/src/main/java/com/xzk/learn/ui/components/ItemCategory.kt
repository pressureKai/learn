package com.xzk.learn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xzk.learn.entry.Category
import com.xzk.learn.entry.Item

@Composable
fun ItemCategory(
    category: Category,
    callback:( item: Item)->Unit
) {

    Card (
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).background(Color.White),
        elevation =  CardDefaults.cardElevation(5.dp,5.dp,5.dp,5.dp,5.dp,5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(8.dp))
            Text(category.name,
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                category.listOfItems.forEach {
                    ItemCard(item = it,callback)
                }
            }
            Spacer(Modifier.height(8.dp))
        }
    }

}

@Composable
@Preview
private fun ItemCategoryPreview() {
    ItemCategory(
        Category(
            "Category 1",
            Item("Item 1","","","", arrayListOf()),
            Item("Item 2","","","", arrayListOf()),
        )
    ) {

    }
}