buildscript {
    val agp_version by extra("7.0.3")
    val agp_version1 by extra("4.2.2")
    val agp_version2 by extra("7.0.0-rc01")
    val agp_version3 by extra("8.3.1")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    // hilt 插件
    id("com.google.dagger.hilt.android") version "2.51" apply false
}