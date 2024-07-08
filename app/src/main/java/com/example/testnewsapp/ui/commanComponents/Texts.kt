package com.example.testnewsapp.ui.commanComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testnewsapp.R


@Composable
fun MainTitle(
    modifier: Modifier = Modifier,
    title: String, maxLines: Int = 2,
    align : TextAlign,
    lineHeight: TextUnit = 16.sp )
{
    Text (
        text = title,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = align,
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis)
}

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    title: String, maxLines: Int = 2,
    align : TextAlign,
    lineHeight: TextUnit = 20.sp )
{
    Text (
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = align,
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis)
}

@Composable
fun SubTitle(
    modifier: Modifier = Modifier,
    title: String,
    maxLines: Int = 1,
    align : TextAlign )
{
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.tertiary,
        textAlign = align,
        modifier = modifier,
        maxLines = maxLines,
        lineHeight = 15.sp,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun GeneralText(
    modifier: Modifier = Modifier,
    title: String,
    maxLines: Int = 1,
    align: TextAlign,
    textColor: Color = MaterialTheme.colorScheme.secondary,
){

    Text(
        modifier = modifier,
        text = title,
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal,
        softWrap = false,
        maxLines = maxLines,
        color = textColor
    )
}

