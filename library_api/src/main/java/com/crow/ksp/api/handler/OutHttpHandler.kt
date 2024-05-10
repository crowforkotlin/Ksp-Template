package com.crow.ksp.api.handler

import androidx.core.net.toUri
import com.crow.ksp.api.RouteHandler
import com.crow.ksp.api.RouteRequest
import com.crow.ksp.api.Router

class OutHttpHandler : RouteHandler {
    override fun handle(request: RouteRequest): Boolean {
        val uri = request.uri
        if (setOf("out-http", "out-https").contains(uri.scheme)) {
            return Router.browse(request.context, uri.toString().substring(4).toUri())
        }
        return false
    }
}