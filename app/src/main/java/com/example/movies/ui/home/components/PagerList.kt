package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.google.android.material.math.MathUtils
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun PagerList(
    results: List<Result>,
    title:String,
    onItemClick: (id: Int) -> Unit,
) {
    val screenHeight  = LocalConfiguration.current.screenHeightDp.dp
    val pagerState = rememberPagerState(pageCount = results.size,infiniteLoop = true)

    Column(Modifier.padding(Padding.medium).height(screenHeight * .45f)) {
        Text(
            text = title,
            style = Typography.h5,
            modifier = Modifier
                .padding(Padding.medium)
                .padding(bottom = Padding.medium)
        )
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
            MovieItem(
                url = MovieApi.IMAGE_URL_ORIGINAL + results[page].posterPath,
                rating = results[page].voteAverage.toFloat(),
                title = results[page].title,
                id = results[page].id,
                onItemClick = onItemClick,
                modifier = Modifier
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        // We animate the scaleX + scaleY, between 85% and 100%
                        MathUtils
                            .lerp(
                                0.85f,
                                1f,
                                1f - pageOffset.coerceIn(0f, 1f)
                            )
                            .also { scale ->
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
            )
        }
    }
}
