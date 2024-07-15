package com.xzk.learn.entry

// vararg 可变参数
class Category(val name: String, vararg item: Item) {
    // 可变参数转换成List
    val listOfItems: List<Item> = item.toList()
}
// summary 概要
val dummyCategories = mutableListOf(
    Category(
        "博客主页",
        Item("博客主页","https://pressurekai.github.io/","博客","博客主页", arrayListOf()),
    ),
    Category(
        "C++",
        Item("Android Jni C++ 日志打印","https://blog.csdn.net/wenzhi20102321/article/details/136419367","Android Jni添加打印（C++打印）","Android Jni添加打印（C++打印）", arrayListOf()),
    ),
    Category(
        "Compose",
        Item("点击事件处理","https://blog.csdn.net/pepsimaxin/article/details/135742686","点击事件处理","点击事件处理",
            arrayListOf()
        ),
        Item("底部导航栏","https://www.cnblogs.com/stars-one/p/17154864.html","底部导航栏","底部导航栏", arrayListOf()),
        Item("书籍翻页","https://github.com/FantasticPornTaiQiang/PTQFlipper","书籍翻页","书籍翻页", arrayListOf()),
        Item("占位空间控件","https://blog.csdn.net/sange77/article/details/126426668","占位空间控件","占位空间控件", arrayListOf()),
        Item("compose项目学习","https://github.com/FunnySaltyFish/JetpackComposeStudy","compose项目学习","compose项目学习", arrayListOf()),
        Item("Hilt用法","https://www.jianshu.com/p/252c407bed19","Hilt用法","Hilt用法", arrayListOf()),
    ),
    Category(
        "Android Framework",
        Item("Android Jni C++ 日志打印","https://blog.csdn.net/wenzhi20102321/article/details/136419367","Android Jni添加打印（C++打印）","Android Jni添加打印（C++打印）", arrayListOf()),
    ),
    Category(
        "Android UI",
        Item("Android Jni C++ 日志打印","https://blog.csdn.net/wenzhi20102321/article/details/136419367","Android Jni添加打印（C++打印）","Android Jni添加打印（C++打印）", arrayListOf()),
    ),

)