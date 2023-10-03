package com.example.movies.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@Composable
fun MovieBottomBar(navController: NavHostController) {

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        BottomBarTab.BottomBarItems.items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route)
                },
                label = { Text(text = stringResource(id = item.titleResourceId)) },
                icon = {
                    Icon(
                        painterResource(
                            if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                        ),
                        contentDescription = null
                    )
                }
            )
        }
    }
}