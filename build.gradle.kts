// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(app.plugins.android.application) apply false
    alias(app.plugins.android.library) apply false
    alias(app.plugins.android.kotlin) apply false
    alias(compose.plugins.about.libraries) apply false
}
true // Needed to make the Suppress annotation work for the plugins block