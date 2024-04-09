package com.example.roomcronoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomcronoapp.viewModel.CronometroViewModel
import com.example.roomcronoapp.viewModel.CronosViewModel
import com.example.roomcronoapp.views.AddView
import com.example.roomcronoapp.views.EditView
import com.example.roomcronoapp.views.HomeView

@Composable
fun NavManager(cronometroViewModel: CronometroViewModel,cronosVM:CronosViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController,cronosVM)
        }
        composable("AddView"){
            AddView(navController,cronometroViewModel,cronosVM)
        }
        composable("EditView/{id}", arguments = listOf(
            navArgument("id"){type = NavType.LongType}
        )){
            val id = it.arguments?.getLong("id")?:0
            EditView(navController,cronometroViewModel,cronosVM,id)
        }
    }
}