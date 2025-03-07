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
fun Receta1View(navController: NavController) {
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
                text = "Garlic Noodles",
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }

        //Imagen
        Image(
            painter = painterResource(R.drawable.garlic),
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

            Lista("3 lbs fresh egg noodles")
            Lista("1/4 cup rice bran oil or vegetable oil")
            Lista("2 1/3 cup soy sauce plus 2 tbsp")
            Lista("3 tbsp brown sugar")
            Lista("2 tbsp water")
            Lista("1 1/2 cup grated parmesan cheese")
            Lista("1/2 lb butter")
            Lista("1/4 cup vegetarian stir fry sauce or mushroom oyster sauce")
            Lista("1/3 cup finely minced garlic")
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

        Instruc("1.", "Heat up a pot of water until boiling. Add the noodles into the boiling water and cook the noodles for about 3-5 minutes until al dente.")
        Instruc("2.", "Drain noodles and rinse with cold water. Shake the colander until the noodles are well drained. Place the noodles in a large bowl or sheet pan and drizzle with oil. Gently toss until evenly coated and set aside. This will prevent the noodles from sticking if you don’t pan fry them right away.")
        Instruc("3.", "In a medium bowl, mix the soy sauce, stir fry sauce, sugar, and water. Stir until the brown sugar is dissolved.")
        Instruc("4.", "Heat a large non-stick sauté pan to medium-high. Melt butter in the sauté pan, add garlic, and sauté until aromatic but not browned. Add noodles and cook for about 1 minute.")
        Instruc("5.", "Add the sauce mix, mix thoroughly, and continue cooking the noodles, making sure they are lightly browning but the garlic isn’t burning.")
        Instruc("6.", "Remove from heat. Taste and adjust seasoning if needed. Put half of the noodles on a platter, layer with half of the Parmesan, and then plate the rest of the noodles. Garnish with the remaining cheese.")

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
