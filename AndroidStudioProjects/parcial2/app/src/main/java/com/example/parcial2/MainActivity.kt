package com.example.parcial2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.parcial2.Nav.Navegacion
import com.example.parcial2.Nav.Producto
import com.example.parcial2.ui.theme.Parcial2Theme
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2Theme {
                val navController = rememberNavController()

                val productos = remember { mutableStateListOf<Producto>() }
                val carrito = remember { mutableStateListOf<Producto>() }

                Navegacion(
                    navController = navController,
                    productos = productos,
                    carrito = carrito,
                    onAgregarProducto = { nuevoProducto ->
                        productos.add(nuevoProducto)
                    },
                    onAgregarAlCarrito = { producto ->
                        carrito.add(producto)
                    },
                    onEliminarProducto = { producto ->
                        productos.remove(producto)
                    }
                )
            }
        }
    }
}
