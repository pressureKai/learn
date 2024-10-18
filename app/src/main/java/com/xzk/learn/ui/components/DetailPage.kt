package com.xzk.learn.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.xzk.learn.R
import com.xzk.learn.ui.theme.Shapes
import com.zzhoujay.richtext.RichText
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


@SuppressLint("SetTextI18n")
@Composable
fun DetailPage() {

    val LocalContext = LocalContext.current
  //  Color bgColor = Color.getBackgroundDisplayMode();
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White, Shapes.large)
            .height(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidView({
             val textView = TextView(LocalContext)
             textView.setTextColor(LocalContext.getColor(R.color.black))
             textView.text = "LocalText"
             textView
        }, modifier = Modifier.height(200.dp),{

            it.setTextColor(LocalContext.getColor(R.color.black))
            it.text = "LocalText"
            RichText.fromMarkdown(readRawResource(LocalContext, R.raw.hello)).into(it)

        })
    }
}


fun readRawResource(context: Context, resourceId: Int): String {
    val stringBuilder = StringBuilder()
    try {
        context.resources.openRawResource(resourceId).use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                BufferedReader(inputStreamReader).use { bufferedReader ->
                    var line: String?
                    while ((bufferedReader.readLine().also { line = it }) != null) {
                        stringBuilder.append(line).append("\n")
                    }
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return stringBuilder.toString()
}