package com.example.movies.ui.home

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.home.components.ImageList


private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val results by remember {
        viewModel.popularResults
    }
    Log.i(TAG, "HomeScreen: ${results.toString()}")

    LazyColumn() {
        items(count = 5) {
            results?.let {
                ImageList(it, "Popular", modifier = Modifier.height(360.dp))
            }
        }
    }
}