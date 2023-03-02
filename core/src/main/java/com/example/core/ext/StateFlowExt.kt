package com.example.core.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

fun <T> StateFlow<T>.lifecycleObserver(
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    lifecycleOwner: LifecycleOwner,
    collector: FlowCollector<T>,
) {
    val stateflow = this
    lifecycleCoroutineScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            stateflow.collect(collector)
        }
    }
}
