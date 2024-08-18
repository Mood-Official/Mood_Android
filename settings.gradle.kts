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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "mood"
include(":app")
include(":feature:sample")
include(":core:designsystem")
include(":core:domain")
include(":core:navigator")
include(":core:remote")
include(":core:local")
include(":core:data")
include(":core:common:android")
include(":core:common:kotlin")
include(":feature:onboard")
include(":feature:meet")
include(":feature:home")
