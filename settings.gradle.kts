pluginManagement {
    repositories {

        maven ("https://maven.aliyun.com/repository/public/" )
        maven ("https://maven.aliyun.com/repository/google/")
        maven ("https://maven.aliyun.com/repository/jcenter/")
        maven { setUrl("https://maven.aliyun.com/nexus/content/groups/public/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }

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
        maven { setUrl("https://maven.aliyun.com/nexus/content/groups/public/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }

        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "learn"
include(":app")
include(":richtext")
include(":markdown")
