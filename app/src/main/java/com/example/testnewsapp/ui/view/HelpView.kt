package com.example.testnewsapp.ui.view

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testnewsapp.R
import com.example.testnewsapp.ui.commanComponents.ExpandableCard
import com.example.testnewsapp.ui.commanComponents.IconButton
import com.example.testnewsapp.ui.commanComponents.SectionTitle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HelpView(
    topAppBar:@Composable ()->Unit
)
{

    var visible by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (visible) 1f else 0.1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "scale"
    )
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(
            durationMillis = 700
        ), label = "alpha"
    )

    LaunchedEffect(key1 = "", block = {
        visible = true
    }
    )

    Scaffold(
        modifier = Modifier,
        topBar = {
            topAppBar()
        },
        content = { innerPadding ->

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            )
            {

                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = 1f
                        this.alpha = alpha
                    }
                )
                {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(15.dp)
                    )
                    {

                        SectionTitle(
                            title = stringResource(id = R.string.faq),
                            align = TextAlign.Center
                        )

                        ExpandableCard(
                            modifier = Modifier.padding(top = 15.dp),
                            title = stringResource(id = R.string.ques_1),
                            description = stringResource(id = R.string.answer_1),
                        )

                        ExpandableCard(
                            modifier = Modifier.padding(top = 15.dp),
                            title = stringResource(id = R.string.ques_2),
                            description = stringResource(id = R.string.answer_2),
                        )

                        SectionTitle(
                            modifier = Modifier.padding(25.dp),
                            title = stringResource(id = R.string.legal),
                            align = TextAlign.Center
                        )

                        IconButton(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = stringResource(id = R.string.privacy),
                            icon = Icons.Filled.Lock,
                            iconTint = MaterialTheme.colorScheme.secondary,
                            onClick = { /*TODO*/ }
                        )

                        SectionTitle(
                            modifier = Modifier.padding(25.dp),
                            title = stringResource(id = R.string.contact_us),
                            align = TextAlign.Center
                        )

                        IconButton(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = stringResource(id = R.string.contact),
                            icon = Icons.Filled.Call,
                            iconTint = MaterialTheme.colorScheme.secondary,
                            onClick = { /*TODO*/ }
                        )

                        IconButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp),
                            text = stringResource(id = R.string.contact_email),
                            icon = Icons.Filled.Email,
                            iconTint = MaterialTheme.colorScheme.secondary,
                            onClick = { /*TODO*/ }
                        )

                    }
                }
            }
        }
    )

}