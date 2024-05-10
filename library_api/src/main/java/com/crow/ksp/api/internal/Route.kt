package com.crow.ksp.api.internal

internal data class Route(val path: String, val clazz: Class<*>, val interceptors: List<String>?, val flags: Int = 0)