package com.example.movies.ui.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.Typography

@Composable
fun NoConnectionScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_no_internet_connection),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(.7f)
        )
        Text(
            text = "No Internet Connection",
            style = Typography.h5,
            modifier = Modifier.fillMaxWidth(.7f)
        )
    }
}