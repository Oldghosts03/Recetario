package com.example.recetario.view

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recetario.R
import com.example.recetario.components.Instruc
import com.example.recetario.components.Lista
import com.example.recetario.components.MainButton
import com.example.recetario.components.Spacers
import com.example.recetario.components.TitleBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Receta2View (navController: NavController) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Recipe Book") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(140,197,	27)
                )
            )
        }
    )
    {
        ContentView(navController)
    }
}


@Composable
private fun ContentView(navController: NavController) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        //Titulo
        Box(modifier = Modifier.padding(top = 130.dp)) {
            Text(
                text = "Chicken Saltimbocca",
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }

        //Imagen
        Image(
            painter = painterResource(R.drawable.chick2),
            contentDescription = "Imagen",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(450.dp, 300.dp)
                .padding(horizontal = 25.dp)
        )

        //Ingredientes
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            colors = CardDefaults.cardColors(Color(61, 184, 225).copy(alpha = 0.2f))
        )
        {
            Text(
                text = "Ingredients",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )

            Lista("8 (6 oz) chicken cutlets")
            Lista("1 tsp salt")
            Lista("1/2 tsp black pepper")
            Lista("16 large fresh sage leaves")
            Lista("16 thin slices prosciutto")
            Lista("3 tbsp olive oil")
            Lista("1 cup dry white wine")
            Lista("1 cup low-sodium chicken broth")
            Lista("1/2 stick butter")
        }

        //Instrucciones
        Box(modifier = Modifier.padding(top = 25.dp))
        {
            Text(
                text = "Instructions",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Instruc("1.", "If the cutlets are thick, place them between wax paper and pound to 1/2-inch thickness. Season with salt and pepper.")
        Instruc("2.", "Place 2 large (or 5 small) sage leaves on each cutlet, then wrap with 2 slices of prosciutto to hold the sage in place.")
        Instruc("3.", "Heat 1 1/2 tbsp olive oil in a skillet over medium heat. Cook 4 cutlets for about 2 minutes per side until cooked through. Transfer to a platter and cover with foil to keep warm. Repeat with the remaining oil and cutlets.")
        Instruc("4.", "Add wine to the skillet, scraping up browned bits, and simmer for 1 minute. Add chicken broth and simmer for 4-5 minutes until slightly reduced.")
        Instruc("5.", "Remove from heat, add butter, and swirl the skillet until the sauce becomes creamy.")
        Instruc("6.", "Spoon 2 tbsp of sauce over each cutlet and serve immediately.")

        //Boton
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        )
        {
            MainButton("Back", 25,150, 75, Color(66, 118, 183 ).copy(alpha = 0.7f), Color.White)
            {
                navController.popBackStack()
            }
        }
    }
}