package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.google.android.material.math.MathUtils
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun MainImageList(
    results: List<Result>,
    title: String,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = results.size, infiniteLoop = true)

    LaunchedEffect(key1 = pagerState.currentPage) {
        delay(3000L)
        pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
    }

    Column(modifier.padding(8.dp)) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 8.dp)
        )
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
            Card(
                Modifier
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        // We animate the scaleX + scaleY, between 85% and 100%
                        MathUtils.lerp(
                            0.85f,
                            1f,
                            1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        // We animate the alpha, between 50% and 100%
                        alpha = MathUtils.lerp(
                            0.5f,
                            1f,
                            1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .fillMaxWidth(0.6f)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                MainImageCard(
                    url = MovieApi.IMAGE_URL + results[page].posterPath,
                    title = results[page].title,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}