package com.crow.ksp.compiler.processor

import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider


@AutoService(SymbolProcessorProvider::class)
class PathProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        println("create")
        environment.logger.run {
            info("Kotlin version: ${environment.kotlinVersion}")
            info("Api Version: ${environment.apiVersion}")
            info("Compile Version: ${environment.compilerVersion}")
            info("Options: ${environment.options}")
        }
        return PathProcessor(environment)
    }
}