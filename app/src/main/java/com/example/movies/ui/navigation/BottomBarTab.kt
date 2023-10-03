package com.example.movies.ui.navigation

import androidx.annotation.StringRes
import com.example.movies.R

sealed class BottomBarTab(
    val route: String,
    @StringRes val titleResourceId: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int
) {
    object Popular : BottomBarTab(
        "popular",
        R.string.popular_bottom_bar_screen,
        R.drawable.ic_popular_filled,
        R.drawable.ic_popular_outlined
    )

    object TopRated : BottomBarTab(
        "top_rated",
        R.string.top_rated_bottom_bar_screen,
        R.drawable.ic_top_rated_filled,
        R.drawable.ic_top_rated_outlined
    )

    object Upcoming : BottomBarTab(
        "upcoming",
        R.string.upcoming_bottom_bar_screen,
        R.drawable.ic_upcoming_filled,
        R.drawable.ic_upcoming_outlined
    )

    object BottomBarItems {
        val items = listOf(Popular, TopRated, Upcoming)
    }
}
