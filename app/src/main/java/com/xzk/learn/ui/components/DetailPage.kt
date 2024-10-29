package com.xzk.learn.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
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
import com.zzhoujay.richtext.callback.DrawableGetter
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


@SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
@Composable
fun DetailPage() {

    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White, Shapes.large),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.statusBarsPadding())
        AndroidView({
             val textView = TextView(context)
             textView.setTextColor(context.getColor(R.color.black))
             textView.text = "LocalText"
             textView
        }, modifier = Modifier,{
            // 设置 TextView 文本内容,使用 requestLayout函数更新布局后
            it.setTextColor(context.getColor(R.color.black))
            it.text = readRawResource(context, R.raw.mn)
            it.setPadding(10,0,10,0)
            it.requestLayout()
            it.post {
                // 布局更改生效后,设置markdown数据
                RichText
                    .fromMarkdown(readRawResource(context, R.raw.mn))
                    .errorImage(DrawableGetter { _, _, _ ->
                         context.getDrawable(R.drawable.ic_launcher_foreground)
                    })
                    .into(it)
            }
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