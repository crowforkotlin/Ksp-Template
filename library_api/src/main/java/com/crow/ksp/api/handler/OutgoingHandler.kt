package com.crow.ksp.api.handler

import com.crow.ksp.api.RouteHandler
import com.crow.ksp.api.RouteRequest
import com.crow.ksp.api.Router

class OutgoingHandler(private val domains: Set<String> = setOf(), private val schemes: Set<String> = setOf()) : RouteHandler {
    override fun handle(request: RouteRequest): Boolean {
        val uri = request.uri
        if (setOf("http", "https").contains(uri.scheme) && (domains.isEmpty() || domains.contains(uri.host))) {
            return Router.browse(request.context, uri)
        }
        if (uri.scheme.isNullOrEmpty()) {
            return false
        }
        if (schemes.isEmpty() || schemes.contains(uri.scheme)) {
            return Router.browse(request.context, uri)
        }
        return false
    }
}