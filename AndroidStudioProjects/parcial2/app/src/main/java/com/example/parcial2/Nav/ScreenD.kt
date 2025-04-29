package com.example.parcial2.Nav




import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PantallaCarrito(
    productosEnCarrito: List<Producto>,
    totalCarrito: Double,
    onFinalizar: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Carrito de Compras", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(productosEnCarrito) { producto ->
                ProductoItem(producto)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text("Total: $${"%.2f".format(totalCarrito)}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onVolver, modifier = Modifier.weight(1f)) {
                Text("Volver al Catálogo")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = onFinalizar, modifier = Modifier.weight(1f)) {
                Text("Finalizar Compra")
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            Text(
                text = producto.nombre,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "$${"%.2f".format(producto.precio)}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaCarrito() {
    val productos = listOf(
        Producto(1, "Producto 1", 10.0, "Descripción 1", ""),
        Producto(2, "Producto 2", 15.0, "Descripción 2", ""),
        Producto(3, "Producto 3", 20.0, "Descripción 3", "")
    )
    val totalCarrito = productos.sumOf { it.precio }

    PantallaCarrito(
        productosEnCarrito = productos,
        totalCarrito = totalCarrito,
        onFinalizar = {},
        onVolver = {}
    )
}
