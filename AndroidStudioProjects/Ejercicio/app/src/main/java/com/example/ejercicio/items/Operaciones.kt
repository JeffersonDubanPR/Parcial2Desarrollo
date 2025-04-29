package com.example.ejercicio.items


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraBasica()
        }
    }
}

@Composable
fun CalculadoraBasica() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))


        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row {
            Button(onClick = { resultado = calcular(numero1, numero2, "+") }) {
                Text("sum")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { resultado = calcular(numero1, numero2, "-") }) {
                Text("Rest")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { resultado = calcular(numero1, numero2, "*") }) {
                Text("Mult")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { resultado = calcular(numero1, numero2, "/") }) {
                Text("Di")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Resultado $resultado", style = MaterialTheme.typography.headlineMedium)
    }
}


fun calcular(num1: String, num2: String, operador: String): String {
    return try {
        val n1 = num1.toDouble()
        val n2 = num2.toDouble()
        when (operador) {
            "+" -> (n1 + n2).toString()
            "-" -> (n1 - n2).toString()
            "*" -> (n1 * n2).toString()
            "/" -> if (n2 != 0.0) (n1 / n2).toString() else "Error"
            else -> "Operación inválida"
        }
    } catch (e: Exception) {
        "Error"
    }
}
