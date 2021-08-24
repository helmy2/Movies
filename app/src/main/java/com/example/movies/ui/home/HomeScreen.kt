package com.example.movies.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import com.example.movies.R
import com.example.movies.data.database.Authentication
import com.example.movies.ui.home.components.HomeAppBar
import com.example.movies.ui.home.components.HomeContent
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography


@Composable
fun HomeScreen(
    onMovieClick: (id: Int) -> Unit,
    onGenreClick: (id: Int) -> Unit,
    onSearchClick: () -> Unit,
    viewModel: HomeViewModel,
    authentication: Authentication
) {
    val popularResults by remember { viewModel.popularResults }
    val topRatedResults by remember { viewModel.topRatedResults }
    val nowPlayingResults by remember { viewModel.nowPlayingResults }
    val upcomingResults by remember { viewModel.upcomingResults }
    val animationResults by remember { viewModel.animationResults }
    val genreListResults by remember { viewModel.genreListResults }
    val authentication0 by remember { viewModel.authentication }

    LaunchedEffect(key1 = true) {
        viewModel.getAuthentication(authentication)
    }


    val drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
    var isDrawerOpen by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = isDrawerOpen) {
        if (isDrawerOpen)
            drawerState.open()
    }

    LaunchedEffect(key1 = drawerState.isClosed) {
        if (drawerState.isClosed)
            isDrawerOpen = false
    }

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            HomeDrawerContent(authentication0)
        },
        content = {
            Scaffold(
                topBar = {
                    HomeAppBar(
                        onSearchClick = onSearchClick,
                        onMenuClick = {
                            isDrawerOpen = true
                        })
                }
            ) {
                HomeContent(
                    genreListResults,
                    onGenreClick,
                    nowPlayingResults,
                    onMovieClick,
                    animationResults,
                    upcomingResults,
                    topRatedResults,
                    popularResults
                )
            }
        })
}

@Composable
fun HomeDrawerContent(authentication: Authentication?) {
    authentication?.let {
        val painter = rememberImagePainter(
            authentication.currentUser()?.photoUrl,
            builder = {
                crossfade(true)
            },
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(Padding.large)
        ) {
            Image(
                painter =
                if (authentication.currentUser() == null) painterResource(id = R.drawable.ic_placeholder_user)
                else painter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(.3f)
                    .clip(shape = CircleShape)
            )
            Text(
                text = authentication.currentUser()?.email ?: "",
                style = Typography.body1,
                modifier = Modifier.padding(Padding.medium)
            )
            Button(onClick = {
                if (authentication.currentUser() == null)
                    authentication.signInGoogle()
                else
                    authentication.signOut()
            }, Modifier.padding(Padding.medium)) {

                Text(text = if (authentication.currentUser() == null) "Login" else "Logout")

            }
        }
    }
}

