pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SDAAPP"
include(":deviceprofile")
//include(":sensor")
include(":sensordatacollection")
//include(":core")
include(":co")
include(":app")
