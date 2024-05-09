package com.crow.ksp.template

import android.app.Application

val app = MainApplication.context

/**
 * ⦁ MainApplication
 *
 * ⦁ 2024-05-09 18:57:22 周四 下午
 * @author crowforkotlin
 */
class MainApplication : Application () {
    companion object { lateinit var context: Application }
    override fun onCreate() {
        super.onCreate()
        context = this
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable -> "Global exception | thread is ${thread.name} | throwable is ${throwable.stackTraceToString()}".error() }
    }
}