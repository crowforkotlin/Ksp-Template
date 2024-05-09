plugins {
    alias(app.plugins.android.application)
    alias(app.plugins.android.kotlin)
    alias(app.plugins.android.ksp)
}

android {
    namespace = "com.crow.ksp.template"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.crow.ksp.template"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":annotation"))
    ksp(project(":compiler"))

    implementation(app.androidx.core)
    implementation(app.androidx.activity)
    implementation(app.androidx.appcompat)
    implementation(app.androidx.material)
    implementation(app.androidx.constraintlayout)
    implementation(app.androidx.lifecycle.runtime.ktx)
    implementation(app.androidx.lifecycle.livedata.ktx)
    implementation(app.androidx.lifecycle.viewmodel.ktx)

    testApi(app.junit.junit)
    androidTestApi(app.androidx.test.junit)
    androidTestApi(app.androidx.test.junit.ktx)
    androidTestApi(app.androidx.test.espresso.core)
}