package com.example.testnewsapp.ui.view.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testnewsapp.ui.commanComponents.AppTopAppBar
import com.example.testnewsapp.ui.commanComponents.GeneralText
import com.example.testnewsapp.ui.commanComponents.MyIcon
import com.example.testnewsapp.ui.view.HelpView
import com.example.testnewsapp.ui.view.HomeView
import com.example.testnewsapp.ui.view.profile.ProfileDetailsView
import com.example.testnewsapp.ui.view.profile.ProfileView
import com.example.testnewsapp.ui.view.profile.RegisterView
import com.example.testnewsapp.viewmodel.NewsViewModel

@Composable
fun Navigation( viewModel: NewsViewModel){
    val navController = rememberNavController()
    var screenTitleId by remember { mutableIntStateOf(Screen.Home.resourceId) }

    // main navigation items
    val items = listOf (
        Screen.Home,
        Screen.Profile,
        Screen.Help
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                containerColor = MaterialTheme.colorScheme.surface

            )
            {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEachIndexed { _, screen ->
                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route }

                    NavigationBarItem(
                        modifier = Modifier
                            .padding()
                            .weight(1f),
                        icon = {
                            if (selected == true) {
                                MyIcon(
                                    screen = screen ,
                                    iconColor = MaterialTheme.colorScheme.primary
                                )

                            } else {
                               MyIcon(
                                   screen = screen ,
                                   iconColor = MaterialTheme.colorScheme.secondary
                               )
                            }
                        },
                        label = {
                            if (selected == true) {
                                GeneralText(
                                    title = stringResource(screen.resourceId),
                                    align = TextAlign.Center,
                                    textColor = MaterialTheme.colorScheme.primary
                                )
                            } else {
                                GeneralText(
                                    title = stringResource(screen.resourceId),
                                    align = TextAlign.Center,
                                    textColor = MaterialTheme.colorScheme.secondary
                                )
                            }
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            screenTitleId = screen.resourceId

                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults
                            .colors(
                                indicatorColor = MaterialTheme.colorScheme.background
                            )
                    )
                }
            }
        }
    )
    { innerPadding ->

// all navigation control here
        val startDestination = Screen.Profile.route

        NavHost(
            navController,
            startDestination = startDestination,
        )
        {
            composable(Screen.Home.route) {
                HomeView(viewModel = viewModel,
                    topAppBar = {
                    AppTopAppBar(
                        titleId = Screen.Home.resourceId,
                        navController = navController
                    )
                    },
                )
            }

            composable(Screen.Profile.route) {
                ProfileView(
                    topAppBar = {
                        AppTopAppBar(
                            titleId = Screen.Profile.resourceId,
                            navController = navController
                        )
                    },
                    navController = navController
                )
            }

            composable(Screen.Help.route) {
                HelpView(topAppBar = { AppTopAppBar(
                    titleId = Screen.Help.resourceId,
                    navController = navController)
                }
                )
            }

            composable(Screen.Register.route) {
                RegisterView(
                    topAppBar = { AppTopAppBar (
                        titleId = Screen.Register.resourceId,
                        navController = navController)
                    },
                    navController = navController
                )
            }

            composable(Screen.ProfileDetails.route) {
                ProfileDetailsView(
                    topAppBar = { AppTopAppBar (
                        titleId = Screen.ProfileDetails.resourceId,
                        navController = navController)
                    },
                    navController = navController
                )
            }
        }
    }
}
