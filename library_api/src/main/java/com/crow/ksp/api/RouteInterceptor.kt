package com.crow.ksp.api


interface RouteInterceptor {
    fun intercept(request: RouteRequest): Boolean
}