package com.gds.brasilnoticias.util

import android.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.coroutineScope
import com.gds.brasilnoticias.util.Constantes.DELAY
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class UtilQueryTextListner(
    lifecycle: Lifecycle,
    private val utilQueryTextListner: (String?)->Unit
):SearchView.OnQueryTextListener,LifecycleObserver,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {
    private val corroutineScope = lifecycle.coroutineScope
    private var serachJob : Job? = null


    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        serachJob?.cancel()
        serachJob = corroutineScope.launch {
            newText?.let {
                delay(DELAY)
                utilQueryTextListner(newText)
            }
        }
        return false
    }

}