package com.example.testnewsapp.ui.view.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testnewsapp.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val iconActive: ImageVector,

)
{
    data object Home : Screen(
        "home",
        R.string.nav_home,
        Icons.Default.Home,

    )

    data object Profile : Screen(
        "profile",
        R.string.nav_profile,
        Icons.Default.AccountCircle,

    )

    data object Register : Screen(
        "register",
        R.string.nav_register,
        Icons.Default.AccountCircle,

    )

    data object ProfileDetails : Screen(
        "profileDetails",
        R.string.nav_profileDetails,
        Icons.Default.AccountCircle,

        )

    data object Help : Screen(
        "help",
        R.string.nav_help,
        Icons.Filled.Info,

    )
}