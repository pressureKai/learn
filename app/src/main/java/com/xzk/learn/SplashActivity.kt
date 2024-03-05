package com.xzk.learn

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCancellationBehavior
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.xzk.learn.ui.theme.LearnTheme

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DecorView不再为SystemUI(状态栏和导航栏等)预留Padding (此代码不能放在 Theme 中)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 加载 Lottie资源
        setContent {
            LearnTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {
                    MessageCard()
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }, 2000)
    }
}

//@Composable invocations can only happen from the context of a @Composable function
//@Composable调用只能发生在@Composable函数的上下文中
@Composable
fun MessageCard(modifier: Modifier = Modifier) {
    val lottieComposition by rememberLottieComposition(
        // "lottie.json" 与 “lottie/” 我这是在 assets 目录里，“lottie/” 存放着相关照片
        spec = LottieCompositionSpec.Asset("animation.json"),
        imageAssetsFolder = "lottie/"
    )
    val lottieAnimationState by animateLottieCompositionAsState(
        composition = lottieComposition, // 动画资源句柄
        isPlaying = true, // 动画播放状态
        speed = 1f, // 动画速度状态
        restartOnPlay = true,// 暂停后重新播放是否从头开始
        iterations = 1000000, // 设置循环播放次数
        cancellationBehavior = LottieCancellationBehavior.Immediately,  // 停止动画时的方式（立即停止、延迟停止）
    )

    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center, // 水平居中
        verticalAlignment = Alignment.CenterVertically  // 垂直居中
    ) {
        LottieAnimation(
            lottieComposition,
            lottieAnimationState,
            modifier = Modifier
                .width(100.dp)
                .aspectRatio(3f) // 保持宽高比
                .scale(scaleX = 2f, scaleY = 2f),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTheme {
        MessageCard()
    }
}