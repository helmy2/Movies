package com.example.movies.ui.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movies.R
import com.example.movies.ui.util.Screen
import com.example.movies.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(Constants.SPLASH_SCREEN_DURATION)
            navController.popBackStack()
            navController.navigate(Screen.HomeScreen.route)
        }
    }
    Icon(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Logo",
        modifier = Modifier
            .fillMaxSize()
            .scale(scale.value),
    )
}
