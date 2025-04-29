package com.example.parcial2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.parcial2.Nav.Navegacion
import com.example.parcial2.Nav.Producto
import com.example.parcial2.ui.theme.Parcial2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()


    val productos = mutableListOf<Producto>()
    val carrito = mutableListOf<Producto>()


    Navegacion(
        navController = navController,
        productos = productos,
        carrito = carrito,
        onAgregarProducto = { producto ->
            productos.add(producto)
        },
        onAgregarAlCarrito = { producto ->
            carrito.add(producto)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
