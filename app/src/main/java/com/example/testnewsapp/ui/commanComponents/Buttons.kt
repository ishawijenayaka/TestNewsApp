package com.example.testnewsapp.ui.commanComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testnewsapp.ui.theme.TestNewsAppTheme

@Composable
fun RoundedCornerButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.secondary,
    cornerRadius: Dp = 12.dp,

) {
    Button(
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(cornerRadius))
            .shadow(1.dp, RoundedCornerShape(cornerRadius)),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(size = cornerRadius),
    )
    {
        Text(
            text = text,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textColor: Color = MaterialTheme.colorScheme.secondary,
) {

  Text(
      modifier =  modifier
          .clickable { onClick() },
      text = text,
      fontSize = 18.sp,
      color = textColor
  )

}


@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    textColor: Color = MaterialTheme.colorScheme.secondary,
    iconPosition: IconPosition = IconPosition.Start, // Enum for icon position
    iconTint: Color = MaterialTheme.colorScheme.primary
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(size = 12.dp),

    ) {
        if (iconPosition == IconPosition.Start) {
            Icon(imageVector = icon, contentDescription = null, tint = iconTint)
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(text = text, color = textColor)
        if (iconPosition == IconPosition.End) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = icon, contentDescription = null, tint = iconTint)
        }
    }
}

enum class IconPosition { Start, End }

@Preview
@Composable
fun PopUpPreview() {
    TestNewsAppTheme {
        RoundedCornerButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Ok",
            onClick = { /*TODO*/ }
        )
    }
}