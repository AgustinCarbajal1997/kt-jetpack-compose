package com.example.learningkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.runtime.* // esta es la que importa todo lo relacionado a get, sets, para manejo de estados
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningkotlin.ui.theme.LearningkotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // es todo lo que se va a visualizar dentro de la app
            Content()
        }
    }
}

/*

Los modificadores nos permiten moldear o personalizar los componentes

4 tipos de modificadores:
- De posicionamiento: width, height
- De funcionalidad:  por ej de click o de scroll
- De apariencia: background, padding, border
- De escucha: Cuando se dispara un evento, por ejemplo onKeyEvent

*/
val items =
    listOf(
        Color.Red,
        Color.Yellow,
        Color.Green,
        Color.Black,
        Color.Cyan,
        Color.DarkGray,
        Color.Blue
    )

val nombre = "Me Gusta"

@Preview(showBackground = true)
@Composable
fun Content() {
    var likes by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Texto("Hola")
        Space()
        Texto(texto = "Como estas?")
        Space()
        Texto(texto = "Chau")
        Space()
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Circulo()
            Circulo()
            Circulo()
            Circulo()
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(items) { item ->
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .background(item, CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Space()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                likes++
            }) {
                Text(text = nombre)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Resultado(likes = likes)
        }
    }
}


@Composable
fun Resultado(likes: Int) {
    Text(text = likes.toString(), fontWeight = FontWeight.Bold, fontSize = 50.sp)
}


@Composable
fun Circulo() {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(Color.Green, CircleShape)
    )
}

@Composable
fun Texto(texto: String) {
    Text(
        text = texto,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 30.dp, vertical = 5.dp)
            .fillMaxWidth()
            .clickable {
                println("Este es el contenido")
            }
    )
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable // composable es un decorador que va a convertir una funcion en un component
fun Greeting(phrase: String, modifier: Modifier = Modifier) {
    Button(onClick = {
        hola()
    }) {
        Text(text = phrase)
    }
}

fun hola() {
    println("Hola desde jetpack compose")
}

@Preview
@Composable
fun Boton() {
    Button(onClick = {
        println("Hola como estas????")
    }) {
        Text(text = "Presionar")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningkotlinTheme {
        Greeting("Hola Agustin")
    }
}

