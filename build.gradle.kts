// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false

    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}
true // Needed to make the Suppress annotation work for the plugins block

//plugins {
//    alias(libs.plugins.gradle.versions)
//    alias(libs.plugins.version.catalog.update)
//
//
//    alias(libs.plugins.kotlin.android) apply false
//    alias(libs.plugins.kapt) apply false
//    alias(libs.plugins.hilt) apply false
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.android.test) apply false
//}
