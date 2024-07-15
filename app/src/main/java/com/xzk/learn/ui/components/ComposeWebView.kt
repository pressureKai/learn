package com.xzk.learn.ui.components

import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

// 创建一个Composable函数，接收URL和生命周期owner
@Composable
fun ComposeWebView(
    url: String,
    modifier: Modifier = Modifier,
    onLoaded: () -> Unit = {}
) {
    var webView: WebView? by remember { mutableStateOf(null) }

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        onLoaded()
                    }

                    override fun onReceivedError(
                        view: WebView?,
                        request: WebResourceRequest?,
                        error: WebResourceError?
                    ) {
                        super.onReceivedError(view, request, error)
                    }
                }
                loadUrl(url)
                webView = this
            }
        },
        modifier = modifier
    )

    // 为了确保WebView填充整个父布局，我们可以使用Box
    Box(modifier = modifier.fillMaxSize()) {
        webView?.let {
            it.layoutParams = it.layoutParams.apply {
                width = ViewGroup.LayoutParams.MATCH_PARENT
                height = ViewGroup.LayoutParams.MATCH_PARENT
            }
            it
        }
    }
}


