package com.rs.sharedelementtransition.core.presentation.navigation

/**
 * Created by shankar
 * Screen helps to define routesbetween screens
 */
sealed class Screen(val route: String) {

    object StartToListScreen: Screen("start_to_list_screen")
    object ListScreenToDetailScreen : Screen("list_to_details_screen")



}