package com.xzk.learn.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xzk.learn.entry.GlobalParams
import com.xzk.learn.ui.theme.Shapes

@SuppressLint("NotConstructor")
@Composable
fun DetailPage() {
    Color bgColor = Color.getBackgroundDisplayMode();
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White,Shapes.large).height(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "详情页面")


    }
}