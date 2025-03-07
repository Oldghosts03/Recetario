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
fun Receta4View (navController: NavController) {
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
                text = "Tiramisú",
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }

        //Imagen
        Image(
            painter = painterResource(R.drawable.tirami),
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

            Lista("3 egg whites")
            Lista("6 egg yolks")
            Lista("6 tbsp sugar")
            Lista("8 oz mascarpone cheese, at room temperature")
            Lista("1 cup freshly brewed espresso, cooled")
            Lista("2 tbsp amaretto or spiced rum")
            Lista("3-4 dozen ladyfingers (store-bought or homemade)")
            Lista("Cocoa powder, for dusting")
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

        Instruc("1.", "Whip the egg whites with 3 tbsp sugar until stiff peaks form (about 3-5 minutes).")
        Instruc("2.", "In a separate bowl, whip the egg yolks with the remaining sugar until thick and pale yellow.")
        Instruc("3.", "Add mascarpone to the egg yolks and mix until smooth.")
        Instruc("4.", "Gently fold the whipped egg whites into the mascarpone mixture.")
        Instruc("5.", "In a shallow dish, combine the espresso and amaretto.")
        Instruc("6.", "Quickly dip each ladyfinger in the espresso mixture (1-2 seconds) and arrange in a single layer in an 8x8 dish or individual ramekins.")
        Instruc("7.", "Spread half of the mascarpone mixture over the ladyfingers.")
        Instruc("8.", "Repeat with another layer of soaked ladyfingers and top with the remaining mascarpone cream.")
        Instruc("9.", "Cover and refrigerate for 4-6 hours. Dust with cocoa powder before serving.")

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