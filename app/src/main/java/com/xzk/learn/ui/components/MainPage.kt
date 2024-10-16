package com.xzk.learn.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xzk.learn.entry.Item
import com.xzk.learn.entry.dummyCategories


// onNavigateToDetail 增加一个回调用于跳转到详情页，不可直接在页面中生成navigationController跳转页面
// https://developer.android.google.cn/guide/navigation/use-graph/navigate?hl=zh-cn

// compose 学习项目
// https://github.com/FunnySaltyFish/JetpackComposeStudy


/**
 * @param  bottomPadding MainPage距离底部的边距
 */
@SuppressLint("NotConstructor")
@Composable
fun MainPage(bottomPadding: Dp,  callback: (item: Item) -> Unit): Density {
    Column(
        // padding : left,top,right,bottom
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp, 0.dp, 0.dp, bottomPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        // 占位空间控件 https://blog.csdn.net/sange77/article/details/126426668
        Spacer(modifier = Modifier.statusBarsPadding())
        //  TabLayout + RecyclerView 联动
        TabSyncComposeScreen(dummyCategories,callback)
        Spacer(modifier = Modifier.navigationBarsPadding())

    }

    return LocalDensity.current

}