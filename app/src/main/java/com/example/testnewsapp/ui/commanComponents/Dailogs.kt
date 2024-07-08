package com.example.testnewsapp.ui.commanComponents

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun ErrorAlertBox(
    onDismiss: () -> Unit,
    title: String,
    text : String
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            )
            {
                Text("OK")
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    )
}

