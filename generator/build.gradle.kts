import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { kotlin("jvm") }

dependencies {
    implementation(libs.kotlinpoet)
    implementation(libs.kotlinpoet.ksp)
    implementation(libs.ksp.api) { exclude(module = "kotlin-reflect") }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xopt-in=com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview",
            "-Xopt-in=com.google.devtools.ksp.KspExperimental",
            "-Xopt-in=kotlin.contracts.ExperimentalContracts"
        )
    }
}