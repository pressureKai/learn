package com.xzk.learn.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xzk.learn.entry.Item
import android.bluetooth.BluetoothDevice.TRANSPORT_LE

@Composable
fun ItemCard(item: Item, callback: (item: Item) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 64.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp, 8.dp, 8.dp, 8.dp)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 64.dp)
                .clickable(onClick = {
                    callback(item)
                })
        ) {
            Text(
                item.name, textAlign = TextAlign.Left,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(8.dp, 0.dp, 8.dp, 0.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }
    }
}

@Preview
@Composable
private fun ItemCardPrev() {
    ItemCard(Item("Item 1", "", "", "", arrayListOf())){

    }
}