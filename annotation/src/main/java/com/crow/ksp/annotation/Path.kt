@file:Suppress("ClassName", "unused", "SpellCheckingInspection")

package com.crow.ksp.annotation

@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class Path(
    val message: String = "Hello, World!"
)