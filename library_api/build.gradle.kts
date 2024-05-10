plugins {
    alias(app.plugins.android.library)
    alias(app.plugins.android.kotlin)
}

android {
    namespace = App.namespaceApi
    compileSdk = App.compileSdkVersion
    defaultConfig {
        minSdk = App.minSdkVersion
        testInstrumentationRunner = App.testInstrumentationRunner
        consumerProguardFiles(App.consumerRulesPro)
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(App.proguardAndroidOptimizeTxt), App.proguardRulesPro)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = App.jvmTarget
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}