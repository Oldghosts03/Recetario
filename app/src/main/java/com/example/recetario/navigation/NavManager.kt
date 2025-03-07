package com.example.recetario.navigation

import android.animation.RectEvaluator
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recetario.view.HomeView
import com.example.recetario.view.Receta1View
import com.example.recetario.view.Receta2View
import com.example.recetario.view.Receta3View
import com.example.recetario.view.Receta4View

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home")
    {
        composable("Home")
        {
            HomeView(navController)
        }

        composable("Receta1")
        {
            Receta1View(navController)
        }
        composable("Receta2")
        {
            Receta2View(navController)
        }
        composable("Receta3")
        {
            Receta3View(navController)
        }
        composable("Receta4")
        {
            Receta4View(navController)
        }


    }
}