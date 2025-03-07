package com.example.recetario.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recetario.R

@Composable
fun TitleView(name: String){
    Text( text=name, fontSize=35.sp, color = Color.Black );
}

@Composable
fun Lista(ingrediente: String) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Image(
            painter = painterResource(R.drawable.check),
            contentDescription = "Imagen",
            modifier = Modifier.size(40.dp).padding(horizontal = 8.dp)
        )

        Column()
        {
            Text(
                text = ingrediente,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 10.dp),
                textAlign = TextAlign.Left
            )
        }
    }
}

@Composable
fun Spacers(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton(name:String, fontsize:Int, width:Int, height:Int, backcolor: Color, color: Color, onClick:()->Unit){
    Button(onClick = onClick,
        modifier = Modifier.size(width.dp, height.dp),
        colors = ButtonDefaults.buttonColors(
        contentColor =  color,
        containerColor = backcolor,
    ))
    {
        Text(text = name, fontSize = fontsize.sp)
    }
}

@Composable
fun Instruc(num:String, instr:String)
{
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Text(
            text = num,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 20.dp),
            textAlign = TextAlign.Center
        )

        Column()
        {
            Box(modifier = Modifier.padding(horizontal = 15.dp))
            {
                Text(
                    text = instr,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}

@Composable
fun Bloquesitos(titulo:String, imagen:Int, descripcion:String, navController: NavController, ruth:String)
{
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color(61, 184, 225).copy(alpha = 0.2f))
    )
    {
        Text(
            text = titulo, fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            textAlign = TextAlign.Center
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(imagen),
                alignment = Alignment.Center,
                contentDescription = "Imagen",
                modifier = Modifier.size(190.dp).padding(10.dp),
                contentScale = ContentScale.Crop
            )


            Column()
            {
                Text(
                    text = descripcion,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 15.dp),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyMedium
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )
                {
                    MainButton("Show Recipe", 15,135, 45, Color(140,197,	27), Color.White)
                    {
                        navController.navigate(ruth)
                    }
                }
            }
        }
    }
}

