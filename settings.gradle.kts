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
        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") } // 카카오 로그인 sdk 경로
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
include(":core:datastore")
