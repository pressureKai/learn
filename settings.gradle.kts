pluginManagement {
    repositories {

        maven ("https://maven.aliyun.com/repository/public/" )
        maven ("https://maven.aliyun.com/repository/google/")
        maven ("https://maven.aliyun.com/repository/jcenter/")

        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven ("https://maven.aliyun.com/repository/public/" )
        maven ("https://maven.aliyun.com/repository/google/")
        maven ("https://maven.aliyun.com/repository/jcenter/")
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "learn"
include(":app")
include(":richtext")
include(":markdown")
