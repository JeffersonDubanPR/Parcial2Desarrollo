package com.example.parcial2.Nav



import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navegacion(
    navController: NavHostController,
    productos: List<Producto>,
    carrito: List<Producto>,
    onAgregarProducto: (Producto) -> Unit,
    onAgregarAlCarrito: (Producto) -> Unit
) {

    val totalCarrito = carrito.sumOf { it.precio }

    NavHost(navController = navController, startDestination = "catalogo") {


        composable("catalogo") {
            PantallaCatalogo(
                productos = productos,
                onProductoClick = { productoId ->

                    val producto = productos.find { it.id == productoId }
                    if (producto != null) {
                        navController.navigate("detalle/${producto.id}")
                    }
                },
                onAgregarClick = {

                    navController.navigate("agregar")
                },
                onCarritoClick = {

                    navController.navigate("carrito/$totalCarrito")
                }
            )
        }


        composable("agregar") {
            PantallaAgregarProducto(
                onGuardar = { producto ->

                    onAgregarProducto(producto)
                    navController.popBackStack()
                },
                onCancelar = {


                    navController.popBackStack()
                }
            )
        }


        composable("detalle/{productoId}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId")?.toIntOrNull()
            val producto = productoId?.let { id -> productos.find { it.id == id } }

            if (producto != null) {
                PantallaDetalleProducto(
                    producto = producto,
                    onAgregarAlCarrito = {
                        onAgregarAlCarrito(it)
                        navController.popBackStack()
                    },
                    onVolver = {
                        navController.popBackStack()
                    }
                )
            }
        }



        composable("carrito/{totalCarrito}") { backStackEntry ->
            val totalCarrito = backStackEntry.arguments?.getString("totalCarrito")?.toDoubleOrNull() ?: 0.0

            PantallaCarrito(
                productosEnCarrito = carrito,
                totalCarrito = totalCarrito,
                onFinalizar = {

                    navController.popBackStack()
                },
                onVolver = {

                    navController.popBackStack()
                }
            )
        }
    }
}


