package com.xzk.learn.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ptq.mpga.ptqbookpageview.widget.PTQBookPageView
import ptq.mpga.ptqbookpageview.widget.rememberPTQBookPageViewState

// Compose 书籍翻页
//https://github.com/FantasticPornTaiQiang/PTQFlipper



@SuppressLint("NotConstructor")
@Composable
fun SettingPage(bottomPadding:Dp) {
    val state by rememberPTQBookPageViewState(pageCount = 100)

    Column(
        // padding : left,top,right,bottom
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, bottomPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 占位空间控件 https://blog.csdn.net/sange77/article/details/126426668
        //  TabLayout + RecyclerView 联动
        PTQBookPageView(state = state) {
            contents { currentPage, refresh ->
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {

                    //任何非动态的自定义内容
                    Column {
                        Text("\ncurrentPage is : $currentPage")
                        Text("currentPage is : $currentPage")
                    }


                }

                refresh()
            }
        }
        Spacer(modifier = Modifier.navigationBarsPadding())

    }


}