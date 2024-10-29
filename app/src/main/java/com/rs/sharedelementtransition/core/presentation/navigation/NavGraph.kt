package com.rs.sharedelementtransition.core.presentation.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rs.sharedelementtransition.feature_menu.presentation.DetailScreen
import com.rs.sharedelementtransition.feature_menu.presentation.ListScreen

/**
 * Created by shankar
 * Navhelper defines to navhigate composables
 */
object NavHelper{

    private fun navigateTo(navController: NavController,route:String){
        when{

            route == Screen.StartToListScreen.route ->{
                navController.navigate(Screen.StartToListScreen.route)
            }

            route == Screen.ListScreenToDetailScreen.route ->{
                navController.navigate(Screen.ListScreenToDetailScreen.route)
            }
        }
    }

    @OptIn(ExperimentalSharedTransitionApi::class)
    @Composable
    fun  SetupNavGraph(navController: NavHostController){
        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = Screen.StartToListScreen.route
            ) {
                composable(Screen.StartToListScreen.route){
                    ListScreen(
                        onItemClick = { resId, text ->
                            navController.navigate(Screen.ListScreenToDetailScreen.route+"/$resId/$text")
                        },
                        animatedVisibilityScope = this
                    )
                }

                composable(
                    route = Screen.ListScreenToDetailScreen.route+"/{resId}/{text}",
                    arguments = listOf(
                        navArgument("resId") {
                            type = NavType.IntType
                        },
                        navArgument("text") {
                            type = NavType.StringType
                        },
                    )
                ) {
                    val resId = it.arguments?.getInt("resId") ?: 0
                    val text = it.arguments?.getString("text") ?: ""
                    DetailScreen(
                        resId = resId,
                        text = text,
                        animatedVisibilityScope = this
                    )
                }

            }


            }

    }



}