package com.example.testnewsapp.ui.commanComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testnewsapp.R

@Composable
fun PasswordFieldWithHint (
    modifier: Modifier,
    labelHint: String,
    initialValue: String,
    onNameChanged: (String) -> Unit,
    isError : Boolean,
    errorMessage:String = ""

){
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = initialValue,
        onValueChange = { onNameChanged(it) },
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() },
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Face

            else Icons.Default.Lock

            val description = if (passwordVisible) stringResource(R.string.hide_password) else stringResource(
                R.string.show_password
            )

            androidx.compose.material3.IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description, tint = MaterialTheme.colorScheme.primary)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            errorTextColor = Color.Black,
        ),
        isError = isError,
        label = {
            Text(
                modifier = Modifier.padding(5.dp),
                text = labelHint,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary,
            )
        },
    )

    if (isError) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(start = 10.dp)
        )
    }

}

@ExperimentalComposeUiApi
@Composable
fun TextFieldWIthHint(
    modifier: Modifier = Modifier,
    labelHint: String,
    initialValue: String,
    onNameChanged: (String) -> Unit,
    isError : Boolean = false,
    errorMessage:String = ""

)
{
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = initialValue,
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        onValueChange = { onNameChanged(it) },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() },
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),

        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            cursorColor = MaterialTheme.colorScheme.primary,
            errorTextColor = Color.Red,

            ),
        label = {
            Text(
                modifier = Modifier.padding(5.dp),
                text = labelHint,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp,
            )
        },

        )

    if (isError) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}