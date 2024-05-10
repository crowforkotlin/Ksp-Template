package com.crow.ksp.api.handler

import android.net.Uri
import android.os.Bundle
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import com.crow.ksp.api.RouteHandler
import com.crow.ksp.api.RouteRequest
import com.crow.ksp.api.Router

/**
 * http/https to WebView
 * */
class WebHttpHandler(private val route: String) : RouteHandler {
    override fun handle(request: RouteRequest): Boolean {
        val uri = request.uri
        if (setOf("web-http", "web-https").contains(uri.scheme)) {
            val bundle = Bundle()
            bundle.putString("url", uri.toString().substring(4))
            return Router.routeTo(request.context, Uri.parse(route), bundle)
        }
        return false
    }
}