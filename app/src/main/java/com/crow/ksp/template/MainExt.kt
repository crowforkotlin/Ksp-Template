package com.crow.ksp.template

import android.os.Build.VERSION_CODES.O
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.crow.ksp.api.RouteCallable
import com.crow.ksp.api.RouteRequest
import com.crow.ksp.api.Router
import com.crow.ksp.annotation.Route
import com.crow.ksp.api.routeTo
import kotlinx.coroutines.MainScope

private const val TAG = "Ksp-Template"
fun Any?.info() { Log.i(TAG, this.toString()) }
fun Any?.error() { Log.e(TAG, this.toString()) }

fun MainActivity.init() = lifecycleScope.launch {
    this@init.packageName.info()
    Router.init(this@init)
    // 通过路由执行代码
    routeTo("callable/demo")
}

@Route("callable/demo")
class callback : RouteCallable {
    override fun call(request: RouteRequest) {
        MainScope().launch {
            "hello".info()
            Toast.makeText(app, "hello,world", Toast.LENGTH_LONG).show()
        }
    }
}