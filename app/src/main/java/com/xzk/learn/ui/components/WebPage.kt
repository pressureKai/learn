package com.xzk.learn.ui.components

import android.annotation.SuppressLint
import android.webkit.WebResourceError
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xzk.learn.decode
import com.xzk.learn.ui.theme.Shapes

@SuppressLint("NotConstructor")
@Composable
fun WebPage(url:String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black, Shapes.large).background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.statusBarsPadding())
        ComposeWebView(url = url.decode())
    }
}