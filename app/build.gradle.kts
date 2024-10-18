plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // kapt 插件
    kotlin("kapt")
    // hilt 插件
    id("dagger.hilt.android.plugin")
}


android {
    namespace = "com.xzk.learn"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.xzk.learn"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // 此两个版本号的指定与gradle设定的版本号无关
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }


    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")




    //

    //lottie动画库-------start
    implementation ("com.airbnb.android:lottie:6.0.0")
    implementation ("com.airbnb.android:lottie-compose:6.0.0")
    //lottie动画库-------end


    //navigation-------start
    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    //navigation-------end


    //tabLayout
    implementation("io.github.ahmad-hamwi:tabsync-compose:1.0.1")


    //翻页器
    implementation("com.github.FantasticPornTaiQiang:PTQFlipper:1.1.0")

    // Hilt  此时定义的版本号需要与project 目录下的build.gradle 中hilt插件定义的版本号一致 - start
    implementation ("com.google.dagger:dagger:2.51")
    kapt ("com.google.dagger:dagger-compiler:2.51")
    api ("com.google.dagger:dagger-android:2.51")
    api ("com.google.dagger:dagger-android-support:2.51")
    kapt ("com.google.dagger:dagger-android-processor:2.51")
    implementation ("com.google.dagger:hilt-android:2.51")
    kapt ("com.google.dagger:hilt-android-compiler:2.51")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    // Hilt - end

    //multidex
    implementation ("androidx.multidex:multidex:2.0.1")

    // Image loading
    implementation("io.coil-kt:coil-compose:1.4.0")


    // Coroutines 协程 - start
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    // Coroutines - end


    // Lifecycle - start
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.7.0")
    // Lifecycle - end

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    val spiderMan = "v1.2.0"
    implementation ("com.github.simplepeng.SpiderMan:spiderman:${spiderMan}")

    //引入本地richText模块
    implementation(project(":richtext"))

}