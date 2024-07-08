package com.example.testnewsapp.ui.view.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testnewsapp.R
import com.example.testnewsapp.ui.commanComponents.EnterAnimation
import com.example.testnewsapp.ui.commanComponents.ErrorAlertBox
import com.example.testnewsapp.ui.commanComponents.MainTitle
import com.example.testnewsapp.ui.commanComponents.PasswordFieldWithHint
import com.example.testnewsapp.ui.commanComponents.RoundedCornerButton
import com.example.testnewsapp.ui.commanComponents.SubTitle
import com.example.testnewsapp.ui.commanComponents.TextButton
import com.example.testnewsapp.ui.commanComponents.TextFieldWIthHint
import com.example.testnewsapp.ui.view.navigation.Screen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterView(
    topAppBar:@Composable ()->Unit,
    navController: NavController
){

    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val showAlert = remember { mutableStateOf(false) }

    fun signUpFunction(){

        if (email.isEmpty() || password.isEmpty()){
            showAlert.value = true
        } else {
            navController.navigate(Screen.ProfileDetails.route)
        }
    }


    Scaffold(
        modifier = Modifier,
        topBar = { topAppBar() },
        content = { innerPadding ->

            EnterAnimation(duration = 1500 ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
//                    .background(color = MaterialTheme.colorScheme.primary)
                        .padding(innerPadding)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally

                )
                {
                    MainTitle(
                        title = "Create Your account",
                        align = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(70.dp))

                    TextFieldWIthHint(
                        modifier = Modifier,
                        labelHint = stringResource(R.string.name),
                        initialValue = name,
                        isError = false,
                        errorMessage = "",
                        onNameChanged = {
                            name = it

                        }
                    )

                    TextFieldWIthHint(
                        modifier = Modifier,
                        labelHint = stringResource(R.string.email_address),
                        initialValue = email,
                        isError = false,
                        errorMessage = "",
                        onNameChanged = {
                            email = it

                        }
                    )

                    PasswordFieldWithHint(
                        modifier = Modifier, //.height(55.dp),
                        labelHint = stringResource(R.string.password),
                        initialValue = password,
                        isError = false,
                        errorMessage = "",
                        onNameChanged = {
                            password = it
                        }
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    RoundedCornerButton(
                        text = "Sign UP",
                        onClick = { signUpFunction() }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    TextButton(
                        text = "Sing in",
                        onClick = { navController.navigate(Screen.Profile.route) }
                    )

                }
            }

            if (showAlert.value){
                ErrorAlertBox(
                    onDismiss = { showAlert.value = false },
                    title = stringResource(id = R.string.error),
                    text = stringResource(id = R.string.empty_fields)
                )
            }
        }
    )
}