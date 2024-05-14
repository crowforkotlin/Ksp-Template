@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package com.crow.ksp.compiler.processor

import com.crow.ksp.annotation.Path
import com.crow.ksp.annotation.Route
import com.crow.ksp.compiler.generator.PathGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.validate

class PathProcessor(private val environment: SymbolProcessorEnvironment) : SymbolProcessor, KSPLogger by environment.logger {

    /**
     * ⦁ 处理注解、及符号，有可能注解在当前轮次中没完全处理，可能需要推送到下次. 正常直接返回emptyList即可
     *
     * ⦁ 2024-05-09 18:45:19 周四 下午
     * @author crowforkotlin
     */
    override fun process(resolver: Resolver): List<KSAnnotated> {

        println("Running")

        // 获取序列（集合）
        val symbols: Sequence<KSAnnotated> = resolver.getSymbolsWithAnnotation(Route::class.java.name)

        // 过滤出无效的符号, validate默认为true，取反表示全都过滤, 这会导致这个序列为空的序列，这一行实际上可注释掉,最后返回一个emptyList()，但你也可以自己对符号进行判断处理
        val invalidSymbol: Sequence<KSAnnotated> = symbols.filter { symbol -> !symbol.validate() }

        // 注释的这一行代码表示 验证当前节点是否是KSFunctionDeclaration， 实际上这是一个表示函数的接口，一般用于对函数进行相关描述、功能定义、
        // symbols.filter { symbol -> symbol.validate { parentNode, currentNode -> currentNode is KSFunctionDeclaration } }

        // 从符号过滤出实例为"类声明"然后遍历
        symbols.filterIsInstance<KSClassDeclaration>()
            .forEach { ksClass ->
                println("[Processor] -> ksClass simpleName is ${ksClass.simpleName} \t ${ksClass.packageName}")
                PathGenerator(
                    environment.codeGenerator,
                    environment.logger,
                    environment.options
                ).generate(resolver, symbols)
            }

        symbols.filterIsInstance<KSFunctionDeclaration>()
            .forEach { ksFunction -> println("[Processor] -> ksFunction simpleName is ${ksFunction.simpleName} \t ${ksFunction.packageName}") }

         return invalidSymbol.toList()
    }
}