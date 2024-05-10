package com.crow.ksp.api.handler

import androidx.core.net.toUri
import com.crow.ksp.api.RouteHandler
import com.crow.ksp.api.RouteRequest
import com.crow.ksp.api.Router

class AliasHandler(private val urls: Map<String, String?>) : RouteHandler {
    override fun handle(request: RouteRequest): Boolean {
        val uri = request.uri.toString()
        val prefix = "alias://"
        if (uri.startsWith(prefix)) {
            val url = urls[uri.substring(prefix.length)] ?: return false
            return Router.routeTo(request.context, url.toUri())
        }
        return false
    }
}