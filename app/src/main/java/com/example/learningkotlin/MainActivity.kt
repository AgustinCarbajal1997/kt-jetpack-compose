package com.example.learningkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Preview(showBackground = true)
@Composable
fun Content() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)
        .padding(horizontal = 10.dp)
        .wrapContentSize(Alignment.Center)
    ) {
        Texto("Hola")
        Space()
        Texto(texto = "Como estas?")
        Space()
        Texto(texto = "Chau")
    }
}

@Composable
fun Texto(texto: String){
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