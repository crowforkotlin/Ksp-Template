package com.crow.ksp.template

import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

private const val TAG = "Ksp-Template"
fun Any?.info() { Log.i(TAG, this.toString()) }
fun Any?.error() { Log.e(TAG, this.toString()) }

fun MainActivity.init() = lifecycleScope.launch {

}