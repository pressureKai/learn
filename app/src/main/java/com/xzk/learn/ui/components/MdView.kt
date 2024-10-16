package com.xzk.learn.ui.components

import android.content.Context
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.UiComposable
import androidx.compose.ui.viewinterop.NoOpUpdate
import java.lang.reflect.Modifier

@Composable
@UiComposable
fun <T : View> MdView(
    factory: (Context) -> T, // android view
    modifier: Modifier, // 修饰符
    update: (T) -> Unit = NoOpUpdate // 加载布局后回调
) {



}