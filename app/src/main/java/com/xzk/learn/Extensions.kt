package com.xzk.learn

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import com.xzk.learn.entry.GlobalParams
import com.xzk.learn.entry.GlobalParams.getDisPlayMode
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * When you want to pass the URL in the URL,
 * please pay attention to the encoding format,
 * otherwise it will cause / be parsed by Navigation as the system directed URL.
 * Please use encode to encode the URL to avoid this problem
 * create by zyique chou 05/11/2022
 *
 *   Compose 报错 navigation destination is not a direct child of this NavGraph
 *   用于解决 导航参数中含字符 "/" 导致导航异常
 *   https://blog.csdn.net/zy_pure_qx/article/details/124716597
 *
 */

fun String.encode() = URLEncoder.encode(this, StandardCharsets.UTF_8.toString()) ?: ""

fun String.decode() = URLDecoder.decode(this, StandardCharsets.UTF_8.toString()) ?: ""

@SuppressLint("ModifierFactoryUnreferencedReceiver")
inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}


fun Color.getBackgroundDisplayMode():Color{
    val disPlayMode = getDisPlayMode()
    return if(disPlayMode){
        Color.Black
    } else {
        Color.White
    }
}


