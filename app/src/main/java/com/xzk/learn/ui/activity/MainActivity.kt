package com.xzk.learn.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.xzk.learn.encode
import com.xzk.learn.entry.HiltDemoData
import com.xzk.learn.ui.components.DetailPage
import com.xzk.learn.ui.components.MainPage
import com.xzk.learn.ui.components.SettingPage
import com.xzk.learn.ui.components.WebPage
import com.xzk.learn.ui.theme.LearnTheme
import com.xzk.learn.ui.theme.Shapes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


//https://www.cnblogs.com/stars-one/p/17154864.html 代码参考链接 NavigationBar
// 在MainPage页面中实现
//  1. 网络中加载一个txt文件解析json,渲染在页面上、跳转至webView详情页
//  2. json 数据结构为 技术分类 - 技术阶段（基础、进阶） - 具体技术  - 技术详情 。


// compose 点击事件处理
// https://blog.csdn.net/pepsimaxin/article/details/135742686


@AndroidEntryPoint
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var hiltDemoData: HiltDemoData

    object Pages {
        const val MAIN_PAGE = "mainPage"
        const val SETTING_PAGE = "settingPage"
        const val DETAIL_PAGE = "detailPage"
        const val WEB_PAGE = "webPage"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

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


       hiltDemoData.printDemoData()

    }

    // 首页导航栏以及页面跳转
    @Composable
    fun MessageCard() {
        var iconHeight: Dp = 0.dp
        var levelHeight: Dp = 0.dp

        var currentSelect by remember {
            mutableIntStateOf(0)
        }

        //导航
        val navController = rememberNavController()

        //定义底部菜单数据
        val menuData = listOf(
            BottomItemData("首页", Icons.Filled.Home),
            BottomItemData("设置", Icons.Filled.Settings)
        )
        // by 关键字委托机制
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // destination 目的地
        val currentDestination = navBackStackEntry?.destination
        Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
            if (currentDestination?.hierarchy?.any {
                    it.route == Pages.MAIN_PAGE ||
                            (it.route != null && it.route!!.contains(Pages.SETTING_PAGE))
                } == true) {
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .background(Color.Red, Shapes.large)
                ) {
                    NavigationBar(
                        modifier = Modifier
                            .background(Color.White, Shapes.large)
                            .height(IntrinsicSize.Min),
                        containerColor = Color.White
                    ) {
                        menuData.forEachIndexed { index, bottomItemData ->
                            NavigationBarItem(
                                modifier = Modifier
                                    .height(IntrinsicSize.Min),
                                selected = index == currentSelect,
                                onClick = {
                                    currentSelect = index
                                    if (currentSelect == 0) {
                                        navController.navigate("MainPage")
                                    } else {
                                        navController.navigate("SettingPage/1?age=9")
                                    }
                                },
                                icon = {
                                    Icon(
                                        modifier = Modifier.onSizeChanged {
                                            it.height.dp.also { iconHeight = it }
                                            Log.d(
                                                "xzk",
                                                "iconHeight height:${iconHeight}"
                                            )
                                        },
                                        imageVector = bottomItemData.icon,
                                        contentDescription = bottomItemData.label
                                    )
                                },
                                label = {
                                    Text(
                                        modifier = Modifier.onSizeChanged {
                                            levelHeight = it.height.dp
                                            Log.d(
                                                "xzk",
                                                "levelHeight height:${levelHeight}"
                                            )
                                        },
                                        text = (bottomItemData.label)
                                    )
                                },
//                              indicatorColor 设置指示器颜色
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color.Black,
                                    unselectedIconColor = Color.Black,
                                    indicatorColor = Color.White
                                )
                            )
                        }
                    }
                }

            }

        }
        ) { innerPadding ->
            // 全局路由配置
            NavHost(navController = navController, startDestination = "MainPage") {
                composable(
                    "${Pages.WEB_PAGE}/{url}",
                    //定义参数类型
                    arguments = listOf(
                        navArgument("url") {
                            type = NavType.StringType
                            defaultValue = "https://www.baidu.com"
                        },
                    )
                )
                { navBackStackEntry ->
                    val url = navBackStackEntry.arguments?.getString("url")
                    url?.let {
                      //  WebPage(url)
                        DetailPage()
                    }
                }
                composable(
                    Pages.MAIN_PAGE
                )
                {
                    // innerPadding.calculateBottomPadding() 为 NavigationBar 的底部边距
                    MainPage(innerPadding.calculateBottomPadding()) { item ->
                        val page = Pages.WEB_PAGE + "/" + item.url.encode()
                        navController.navigate(page)
                    }
                }
                composable(
                    Pages.DETAIL_PAGE
                )
                {
                    DetailPage()
                }
                // 页面参数跳转
                composable(
                    "${Pages.SETTING_PAGE}/{id}?age={age}",
                    //定义参数类型
                    arguments = listOf(
                        navArgument("id") {
                            type = NavType.IntType
                            defaultValue = 0
                        },
                        navArgument("age") {
                            type = NavType.IntType
                            defaultValue = 0
                        },
                    )
                ) { navBackStackEntry ->
                    //通过 NavBackStackEntry 获取指定key和类型的数据
                    val id = navBackStackEntry.arguments?.getInt("id")
                    val age = navBackStackEntry.arguments?.getInt("age")
                    Log.e("MainActivity", "id is $id age is $age")
                    //通过参数传递给下一个页面
                    SettingPage(innerPadding.calculateBottomPadding())
                }
            }

        }
    }


    data class BottomItemData(val label: String, val icon: ImageVector)
}