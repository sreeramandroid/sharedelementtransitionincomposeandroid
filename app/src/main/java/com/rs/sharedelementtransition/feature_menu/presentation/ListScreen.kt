package com.rs.sharedelementtransition.feature_menu.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rs.sharedelementtransition.R
/**
 * Created by shankar
 * Screen used to display list of menu items with image and name and to perform shared element tranisitions
 *
 **/
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.ListScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    onItemClick: (Int, String) -> Unit
) {
    val drawables = listOf(
        R.drawable.pizza,
        R.drawable.burger,
        R.drawable.noodles,
        R.drawable.ragadichaat,
        R.drawable.panipuri,
        R.drawable.pavbhaji,
        R.drawable.vadapavv
    )

    val stringItems = listOf(
        "pizza",
        "burger",
        "noodles",
        "chaat",
        "panipuri",
        "paav bhaji",
        "vadapaav"

    )
    Column(modifier = Modifier.fillMaxSize().padding(top = 10.dp)) {
        LazyColumn(
            modifier = Modifier.background(Color.White).padding(start = 10.dp, top = 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(drawables) { index, resId ->
                val text = stringItems.get(index)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(resId, text) }
                ) {
                    Image(
                        painter = painterResource(id = resId),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(16 / 9f)
                            .weight(1f)
                            .sharedElement(
                                state = rememberSharedContentState(key = "image/$resId"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 1000)
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = text,
                        modifier = Modifier
                            .weight(1f)
                            .sharedElement(
                                state = rememberSharedContentState(key = "text/$text"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 1000)
                                }
                            )
                    )
                }
            }
        }
    }
}

