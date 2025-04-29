package com.example.parcial2.Nav

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.random.Random

import androidx.compose.material3.*


data class ProductoForm(
    var nombre: String = "",
    var precio: String = "",
    var descripcion: String = "",
    var imagenUrl: String = ""
)

@Composable
fun PantallaAgregarProducto(
    onGuardar: (Producto) -> Unit,
    onCancelar: () -> Unit
) {
    var formState by remember { mutableStateOf(ProductoForm()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Agregar Producto", style = MaterialTheme.typography.headlineMedium)

        TextField(
            value = formState.nombre,
            onValueChange = { formState = formState.copy(nombre = it) },
            label = { Text("Nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = formState.precio,
            onValueChange = { formState = formState.copy(precio = it) },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = formState.descripcion,
            onValueChange = { formState = formState.copy(descripcion = it) },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = formState.imagenUrl,
            onValueChange = { formState = formState.copy(imagenUrl = it) },
            label = { Text("URL de Imagen") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onCancelar) { Text("Cancelar") }
            Button(onClick = {
                if (formState.nombre.isNotBlank() && formState.precio.isNotBlank()) {
                    val producto = Producto(
                        id = (0..1000).random(),
                        nombre = formState.nombre,
                        precio = formState.precio.toDouble(),
                        descripcion = formState.descripcion,
                        imagenUrl = formState.imagenUrl
                    )
                    onGuardar(producto)
                }
            }) { Text("Guardar") }
        }
    }
}
