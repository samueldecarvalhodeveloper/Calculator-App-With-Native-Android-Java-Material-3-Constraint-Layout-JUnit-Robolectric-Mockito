plugins {
    alias(libs.plugins.androidApplication) apply false
}

buildscript {
    dependencies {
        classpath(libs.gradle)
        classpath(libs.hilt.android.gradle.plugin)
    }
}
