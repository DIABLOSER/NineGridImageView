pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()

        //下面三个是我们自己加的
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url  = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url  = uri("https://maven.aliyun.com/repository/central") }



    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
        //下面两个是我们自己加的
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }


    }
}

rootProject.name = "My Application"
include(":app")
include(":library")
