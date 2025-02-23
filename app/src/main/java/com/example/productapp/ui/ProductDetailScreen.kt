package com.example.productapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productapp.R
import com.example.productapp.ui.model.Product
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(productId: Int, navController: NavController) {
    val products = listOf(
        Product(1, "DANVOUY Women's T Shirt", "95% Cotton, 5% Spandex. Features: Casual, Short Sleeve, Letter Print V-Neck Fashion. The fabric is soft and has some stretch.", 12.99, R.drawable.tshirt_purple, 4.5f),
        Product(2, "Opna Women's Short Sleeve", "100% Polyester, Machine Wash, 100% cationic polyester interlock. Machine Wash & Pre Shrunk for a Great Fit", 7.95, R.drawable.tshirt_red, 0.0f),
        Product(3, "MBJ Women's Solid Short", "95% RAYON 5% SPANDEX, Made in USA or Imported, Do Not Bleach, Lightweight fabric with great stretch for comfort", 9.85, R.drawable.tshirt_white, 0.0f),
        Product(4, "Rain Jacket Women", "Lightweight perfect for trip or casual wear----long sleeve with hooded, adjustable waist design. Button and zipper closure", 39.99, R.drawable.jacket_blue, 0.0f)
    )
    val product = products.find { it.id == productId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            if (product != null) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rating: ★ ${product.rating}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                Text(text = "Không tìm thấy sản phẩm")
            }
        }
    }
}