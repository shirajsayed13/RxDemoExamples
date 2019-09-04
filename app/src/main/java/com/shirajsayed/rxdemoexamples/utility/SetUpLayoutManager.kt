package com.shirajsayed.rxdemoexamples.utility

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object SetUpLayoutManager {
    fun verticalLinearLayout(context: Context, targetRecyclerView: RecyclerView) {
        val placeLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        targetRecyclerView.setHasFixedSize(true)
        targetRecyclerView.layoutManager = placeLayoutManager
    }
}