plugins {
    alias(app.plugins.android.ksp)
    kotlin("jvm")
}

dependencies {
    implementation(project(":module_annotation"))
    implementation(libs.kotlinpoet)
    implementation(libs.kotlinpoet.ksp)
    implementation(libs.ksp.api) { exclude(module = "kotlin-reflect") }
    implementation(libs.ksp.autoservice.annotations)
    ksp(libs.ksp.autoservice)

}

/*tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xopt-in=com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview",
            "-Xopt-in=com.google.devtools.ksp.KspExperimental",
            "-Xopt-in=kotlin.contracts.ExperimentalContracts"
        )
    }
}*/