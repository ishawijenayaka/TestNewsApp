package com.example.testnewsapp.ui.commanComponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
        }
    }
}
