package com.example.parcial2.Nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.parcial2.Nav.Producto

@Composable
fun PantallaCarrito(
    productosEnCarrito: List<Producto>,
    totalCarrito: Double,
    onFinalizar: () -> Unit,
    onVolver: () -> Unit
) {
    var mostrarConfirmacion by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5DC))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Carrito", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(productosEnCarrito) { producto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(producto.nombre)
                            Text("Precio: $${producto.precio}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Total: $${String.format("%.2f", totalCarrito)}")

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { mostrarConfirmacion = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text("Finalizar", color = Color.White)
                }

                Button(
                    onClick = onVolver,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336))
                ) {
                    Text("Volver", color = Color.White)
                }
            }
        }

        if (mostrarConfirmacion) {
            AlertDialog(
                onDismissRequest = { mostrarConfirmacion = false },
                confirmButton = {
                    TextButton(onClick = {
                        mostrarConfirmacion = false
                        onFinalizar()
                    }) {
                        Text("Aceptar")
                    }
                },
                title = { Text("Compra Finalizada") },
                text = { Text("¡Gracias por tu compra!") }
            )
        }
    }
}
