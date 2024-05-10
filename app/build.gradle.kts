plugins {
    alias(app.plugins.android.application)
    alias(app.plugins.android.kotlin)
    alias(app.plugins.android.ksp)
}

android {
    namespace = App.namespaceApp
    compileSdk = App.compileSdkVersion
    defaultConfig {
        applicationId = App.applicationId
        minSdk = App.minSdkVersion
        targetSdk = App.targetSdkVersion
        versionCode = App.versionCode
        versionName = App.versionName
        testInstrumentationRunner = App.testInstrumentationRunner
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(App.proguardAndroidOptimizeTxt), App.proguardRulesPro)
        }
    }
    kotlin {
        sourceSets.debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
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

ksp {
    arg("router.moduleName", "app")
    arg("router.packageName", "com.crow.ksp.template")
}
dependencies {
    implementation(project(":library_api"))
    api(project(":module_annotation"))
    ksp(project(":module_compiler"))

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