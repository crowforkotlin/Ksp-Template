package com.crow.ksp.api


interface RouteHandler {
    fun handle(request: RouteRequest): Boolean
}