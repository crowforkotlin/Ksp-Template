package com.crow.ksp.compiler.processor

import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider


@AutoService(SymbolProcessorProvider::class)
class PathProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        println("[PathProcessorProvider] create!")
        environment.apply {
            logger.info("Kotlin version: $kotlinVersion")
            logger.info("Api Version: $apiVersion")
            logger.info("Compile Version: $compilerVersion")
            logger.info("Options: $options")
        }
        return PathProcessor(environment)
    }
}