package com.example.productapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.ui.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavController) {
    val products = listOf(
        Product(
            1, "Màn hình AOC 24G4E 24\" IPS 180Hz", "Màn hình gaming siêu nhanh: tần số quét 180Hz, phản hồi 0.5ms, G-Sync Compatible. Hình ảnh sắc nét, mượt mà, sẵn sàng cho mọi trận chiến!",
            2890000.0, R.drawable.aoc_24g4e, 4.5f
        ),
        Product(
            2, "Màn hình LG 24GS65F-B 24\" IPS 180Hz HDR10 Gsync", "Màn hình gaming đỉnh cao: tần số quét 180Hz, phản hồi 1ms, hỗ trợ G-Sync và HDR10. Hình ảnh sống động, mượt mà, tối ưu cho mọi trận đấu!",
            3350000.0, R.drawable.lg_24gs65f_b, 0.0f
        ),
        Product(
            3, "Màn hình ViewSonic VX2758A-2K-PRO-3 27\"", "Màn hình gaming đỉnh cao: độ phân giải 2K QHD, tần số quét 240Hz, phản hồi 1ms. Công nghệ FreeSync Premium chống xé hình, HDR10 cho màu sắc sống động. Sẵn sàng cho trải nghiệm mượt mà, sắc nét!",
            6890000.0, R.drawable.vx2758a_2k_pro, 4.9f
        ),
        Product(
            4, "Màn hình Gaming Xiaomi G27QI 27\"", "Gaming đỉnh cao với 2K QHD, tần số quét 180Hz, phản hồi 1ms. FreeSync mượt mà, HDR10 rực rỡ – chiến game đã mắt, không giật lag!",
            4490000.0, R.drawable.xiaomi_g27qi, 4.6f
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sản phẩm mới", color = MaterialTheme.colorScheme.onPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Xử lý nút menu */ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Trang chủ") },
                    selected = false,
                    onClick = { navController.navigate("home") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                    label = { Text("Giỏ hàng") },
                    selected = false,
                    onClick = { /* Xử lý nút Cart */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Cart") },
                    label = { Text("Yêu thích") },
                    selected = false,
                    onClick = {  }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Trang cá nhân") },
                    selected = false,
                    onClick = { /* Xử lý nút Profile */ }
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 8.dp)
        ) {
            items(products) { product ->
                ProductCard(product = product, onClick = { navController.navigate("product_detail/${product.id}") })
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                val formattedPrice = String.format("%,.0f", product.price).replace(",", ".")
                Text(
                    text = "${formattedPrice}đ",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
//                IconButton(onClick = {  }) {
//                    Icon(
//                        imageVector = Icons.Default.Add,
//                        contentDescription = "Add to Cart",
//                        tint = MaterialTheme.colorScheme.primary
//                    )
//                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add to Cart",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "THÊM VÀO GIỎ HÀNG",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }

            Text(
                text = "★ ${product.rating}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}