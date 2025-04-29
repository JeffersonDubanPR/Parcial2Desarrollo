package com.example.parcial2.Nav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaCatalogo(
    productos: List<Producto>,
    onProductoClick: (Int) -> Unit,
    onAgregarClick: () -> Unit,
    onCarritoClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        Text("Catálogo de Productos", style = MaterialTheme.typography.headlineMedium)

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(productos) { producto ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clickable { onProductoClick(producto.id) }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = producto.imagenUrl,
                            contentDescription = producto.nombre,
                            modifier = Modifier.size(80.dp)
                        )
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(producto.nombre)
                            Text("Precio: $${producto.precio}")
                        }
                    }
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onAgregarClick) { Text("Agregar Producto") }
            Button(onClick = onCarritoClick) { Text("Ver Carrito") }
        }
    }
}

@Composable
fun AsyncImage(model: String, contentDescription: String, modifier: Modifier) {
    TODO("Not yet implemented")
}

