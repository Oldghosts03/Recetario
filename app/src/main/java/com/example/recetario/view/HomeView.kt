package com.example.recetario.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recetario.R
import com.example.recetario.components.Bloquesitos
import com.example.recetario.components.MainButton
import com.example.recetario.components.Spacers
import com.example.recetario.components.TitleBar
import com.example.recetario.components.TitleView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Recipe Book") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(140,197,	27)
                )
            )
        },
    )
    {
        ContentView(navController)
    }
}

@Composable
private fun ContentView(navController: NavController)
{
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scroll).padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Bloquesitos("Garlic Noodles", R.drawable.garlic,"Rich, buttery, and packed with savory garlic flavor. Quick to make and perfectly balanced with soy sauce, brown sugar, and Parmesan, they’re a deliciously simple dish!", navController, "Receta1")
        Spacers()
        Bloquesitos("Chicken Saltimbocca", R.drawable.chick,"Flavorful Italian dish with tender chicken, crispy prosciutto, and fragrant sage. Finished with a rich white wine sauce, it’s elegant yet easy to make!", navController, "Receta2")
        Spacers()
        Bloquesitos("Caprese salad", R.drawable.caps,"Fresh, vibrant dish made with juicy tomatoes, creamy mozzarella, and fragrant basil. Drizzled with olive oil and balsamic, it’s simple, delicious, and full of flavor!", navController, "Receta3")
        Spacers()
        Bloquesitos("Tiramisú", R.drawable.tirami,"Rich, creamy dessert with layers of espresso-soaked ladyfingers and mascarpone cream. Light and indulgent, it’s a perfect balance of sweetness and coffee flavor!", navController, "Receta4")
        Spacers()

    }
}