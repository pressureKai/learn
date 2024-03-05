package com.xzk.learn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.xzk.learn.ui.theme.LearnTheme

//https://www.cnblogs.com/stars-one/p/17154864.html
class MainActivity : ComponentActivity() {
    object Pages{
        const val MainPage = "mainPage"
        const val SettingPage = "settingPage"
        const val DetailPage = "detailPage"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MessageCard(modifier: Modifier = Modifier) {
        var currentSelect by remember {
            mutableIntStateOf(0)
        }

        //导航
        val navController = rememberNavController()

        val menuData = listOf(
            BottomItemData("首页", Icons.Filled.Home),
            BottomItemData("设置", Icons.Filled.Settings)
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
            if (currentDestination?.hierarchy?.any { it.route == Pages.MainPage || it.route == Pages.SettingPage } == true) {
                NavigationBar() {
                    menuData.forEachIndexed { index, bottomItemData ->
                        NavigationBarItem(
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
                                    imageVector = bottomItemData.icon,
                                    contentDescription = bottomItemData.label
                                )
                            },
                            label = {
                                Text(
                                    text = (bottomItemData.label)
                                )
                            },
                        )
                    }
                }
            }

        }
        ) { innerPadding ->
            //IDE强制要使用者innerPadding,这里就简单的打印一下
            println(innerPadding)
            // 底部导航路由
            NavHost(navController = navController, startDestination = "MainPage") {
                composable("${Pages.MainPage}") {
                    MainPage {
                        navController.navigate(Pages.DetailPage)
                    }
                }
                composable("${Pages.DetailPage}") {
                    DetailPage()
                }
                composable("${Pages.SettingPage}/{id}?age={age}", arguments = listOf(
                    navArgument("id") {
                    type = NavType.IntType
                    },
                    navArgument("age") {
                        type = NavType.IntType
                        defaultValue = 0
                    },
                )) {
                    SettingPage()
                }
            }

        }
    }

    // onNavigateToDetail 增加一个回调用于跳转到详情页，不可直接在页面中生成navigationController跳转页面
    // https://developer.android.google.cn/guide/navigation/use-graph/navigate?hl=zh-cn
    @Composable
    fun MainPage( onNavigateToDetail: () -> Unit,) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "主页")
            Button(onClick = {
               onNavigateToDetail()
            }) {
               Text(text = "new page")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SettingPage() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "设置页面")
        }
    }

    @Composable
    fun DetailPage() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "详情页面")
        }
    }

    data class BottomItemData(val label: String, val icon: ImageVector)
}