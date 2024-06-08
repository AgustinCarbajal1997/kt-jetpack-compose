package com.example.learningkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningkotlin.ui.theme.LearningkotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // es todo lo que se va a visualizar dentro de la app
               Content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content() {
    Text(text = "Este es el contenido")
}


@Composable // composable es un decorador que va a convertir una funcion en un component
fun Greeting(phrase: String, modifier: Modifier = Modifier) {
    Button(onClick = {
        hola()
    }) {
        Text(text = phrase)
    }
}

fun hola(){
    println("Hola desde jetpack compose")
}

@Preview
@Composable
fun Boton(){
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