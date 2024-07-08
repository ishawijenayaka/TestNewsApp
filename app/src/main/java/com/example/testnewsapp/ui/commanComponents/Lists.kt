package com.example.testnewsapp.ui.commanComponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.testnewsapp.model.Article

@Composable
fun AnimatedArticle(
    article: Article,
    modifier: Modifier = Modifier,
//    isVisible: Boolean
) {
    AnimatedVisibility(
        visible = true,
        enter = scaleIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            initialScale = 0.5f
        ),
        exit = scaleOut(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            targetScale = 0.5f
        )
    )
    {
        Column (
            modifier = modifier.padding(10.dp)
        )
        {
            SectionTitle(
                title = article.title,
                align = TextAlign.Justify
            )

            article.author?.let {
                SubTitle(
                    title = it,
                    align = TextAlign.Justify
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp),
                color = MaterialTheme.colorScheme.primary,
                thickness = 1.dp
            )
        }
    }
}

@Composable
fun AnimatedArticleWithImage(
    article: Article,
    modifier: Modifier = Modifier,
)
{
    AnimatedVisibility(
        visible = true,
        enter = scaleIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            initialScale = 0.5f
        ),
        exit = scaleOut(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            targetScale = 0.5f
        )
    )
    {
        Column (
            modifier = modifier.padding(10.dp)
        )
        {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.urlToImage)
                    .crossfade(200)
                    .build(),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                contentDescription = "description"
            )

            SectionTitle(
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                title = article.title,
                align = TextAlign.Justify
            )

            article.author?.let {
                SubTitle(
                    title = it,
                    align = TextAlign.Justify
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp),
                color = MaterialTheme.colorScheme.primary,
                thickness = 1.dp
            )
        }
    }
}