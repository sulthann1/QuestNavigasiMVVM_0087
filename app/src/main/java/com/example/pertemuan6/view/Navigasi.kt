package com.example.pertemuan6.view


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Navigasi.Formulirku.name
    ) {
        composable(route = Navigasi.Formulirku.name) {
            FormIsian(
                OnSubmitBtnClick = {
                    navController.navigate(Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name) {
            TampilData(
                onBackBtnClick = {
                    cancelAndBackToFormulir(navController)
                }
            )
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Formulirku.name, inclusive = false)
}