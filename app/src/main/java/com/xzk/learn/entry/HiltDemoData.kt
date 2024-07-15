package com.xzk.learn.entry

import android.util.Log
import javax.inject.Inject

// Hilt用法
// https://www.jianshu.com/p/252c407bed19
class HiltDemoData  @Inject constructor() {
    var name: String = ""

    fun printDemoData() {
        Log.e("HiltDemoData", "HiltDemoData name is : $name")
    }
}