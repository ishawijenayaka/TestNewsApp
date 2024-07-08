package com.example.testnewsapp.ui.view.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testnewsapp.R
import com.example.testnewsapp.ui.commanComponents.MainTitle
import com.example.testnewsapp.ui.commanComponents.SectionTitle
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

@Composable
fun ProfileDetailsView(
    topAppBar:@Composable ()->Unit,
    navController: NavController
)
{
    Scaffold(
        modifier = Modifier,
        topBar = {
            topAppBar()
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
            )
            {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    MainTitle(
                        title = stringResource(id = R.string.congrats),
                        align = TextAlign.Center
                    )

                    SectionTitle(
                        modifier = Modifier.padding(20.dp),
                        title = stringResource(id = R.string.congrats_msg_login),
                        align = TextAlign.Justify
                    )
                }

                KonfettiView(
                    modifier = Modifier.fillMaxSize(),
                    parties = listOf(
                        Party(
                            speed = 0f,
                            maxSpeed = 30f,
                            damping = 0.9f,
                            spread = 360,
                            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                            position = Position.Relative(0.5, 0.3),
                            emitter = Emitter(
                                duration = 100,
                                TimeUnit.MILLISECONDS
                            ).max(100)
                        )
                    )
                )
            }
        }
    )

}