package com.example.ejercicio
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio.items.CalculadoraBasica

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CalculadoraBasica()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    CalculadoraBasica()
}


