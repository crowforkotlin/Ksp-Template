package com.crow.ksp.api.internal


internal data class RouteRegex(val regex: Regex, val params: List<String>, val route: Route)