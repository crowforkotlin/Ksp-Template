package com.crow.ksp.api


interface RouteCallable {
    fun call(request: RouteRequest)
}