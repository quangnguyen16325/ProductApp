package com.example.productapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.ui.model.Comment
import com.example.productapp.ui.model.Product
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(productId: Int, navController: NavController) {
    val products = listOf(
        Product(1, "Màn hình AOC 24G4E 24\" IPS 180Hz", "Màn hình gaming siêu nhanh: tần số quét 180Hz, phản hồi 0.5ms, G-Sync Compatible.", 2890000.0, R.drawable.aoc_24g4e, 4.5f),
        Product(2, "Màn hình LG 24GS65F-B 24\" IPS 180Hz HDR10 Gsync", "Màn hình gaming đỉnh cao: tần số quét 180Hz, phản hồi 1ms, hỗ trợ G-Sync và HDR10.", 3350000.0, R.drawable.lg_24gs65f_b, 0.0f),
        Product(3, "Màn hình ViewSonic VX2758A-2K-PRO-3 27\"", "Màn hình gaming đỉnh cao: độ phân giải 2K QHD, tần số quét 240Hz, phản hồi 1ms.", 6890000.0, R.drawable.vx2758a_2k_pro, 4.9f),
        Product(4, "Màn hình Gaming Xiaomi G27QI 27\"", "Gaming đỉnh cao với 2K QHD, tần số quét 180Hz, phản hồi 1ms.", 4490000.0, R.drawable.xiaomi_g27qi, 4.6f)
    )
    val product = products.find { it.id == productId }
    val comments = listOf(
        Comment(1, "Quang Nguyễn", "Màn hình siêu mượt, 180Hz thực sự làm thay đổi trải nghiệm chơi game của tôi!", SimpleDateFormat("dd/MM/yyyy").parse("24/02/2025") ?: Date(), 1),
        Comment(5, "Mỹ Hoa", "Màn hình đẹp, màu sắc sống động, nhưng sync hơi lag khi chơi game nặng.", SimpleDateFormat("dd/MM/yyyy").parse("28/02/2025") ?: Date(), 1),
        Comment(2, "Huy Nguyễn", "Hình ảnh đẹp, HDR10 rất ấn tượng, nhưng giá hơi cao so với túi tiền.", SimpleDateFormat("dd/MM/yyyy").parse("25/02/2025") ?: Date(), 3),
        Comment(3, "Thọ Lê", "240Hz và 2K là combo hoàn hảo, chơi FPS cực kỳ đã, không có gì để chê!", SimpleDateFormat("dd/MM/yyyy").parse("26/02/2025") ?: Date(), 1),
        Comment(4, "Khôi Lê", "Giá tốt trong phân khúc, HDR10 và 180Hz đủ dùng cho cả game lẫn công việc.", SimpleDateFormat("dd/MM/yyyy").parse("27/02/2025") ?: Date(), 3),
        Comment(6, "Minh Anh", "Chơi game mượt, nhưng góc nhìn hơi hẹp khi ngồi lệch.", SimpleDateFormat("dd/MM/yyyy").parse("01/03/2025") ?: Date(), 1),
        Comment(7, "Văn Tùng", "Màn hình này đáng giá từng đồng, 2K và 240Hz quá đỉnh!", SimpleDateFormat("dd/MM/yyyy").parse("02/03/2025") ?: Date(), 1),
        Comment(8, "Lan Phương", "HDR10 làm màu sắc rực rỡ, rất hài lòng với mức giá này.", SimpleDateFormat("dd/MM/yyyy").parse("03/03/2025") ?: Date(), 4),
        Comment(9, "Nguyễn Nguyên", "G-Sync hoạt động tốt, không bị xé hình khi chơi game nặng.", SimpleDateFormat("dd/MM/yyyy").parse("04/03/2025") ?: Date(), 3),
        Comment(10, "Thảo Linh", "Màn hình đẹp, nhưng loa tích hợp hơi yếu, cần thêm loa ngoài.", SimpleDateFormat("dd/MM/yyyy").parse("05/03/2025") ?: Date(), 4),
        Comment(11, "Hoàng Nam", "FreeSync mượt mà, chơi game không lag, rất đáng mua!", SimpleDateFormat("dd/MM/yyyy").parse("06/03/2025") ?: Date(), 4),
        Comment(12, "Bảo Ngọc", "Độ phân giải 2K tuyệt vời, nhưng hơi nóng sau vài giờ sử dụng.", SimpleDateFormat("dd/MM/yyyy").parse("07/03/2025") ?: Date(), 1)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chi tiết sản phẩm", color = MaterialTheme.colorScheme.onPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
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
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val formattedPrice = String.format("%,.0f", product.price).replace(",", ".")
                    Text(
                        text = "$formattedPrice đ",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Button(
                        onClick = { /* Xử lý thêm vào giỏ hàng */ },
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
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Đánh giá: ★ ${product.rating}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Bình luận (${comments.count { it.productId == productId }})",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                val productComments = comments.filter { it.productId == productId }
                if (productComments.isNotEmpty()) {
                    Column {
                        productComments.take(3).forEach { comment ->
                            CommentCard(comment = comment)
                        }
                        if (productComments.size > 3) {
                            TextButton(
                                onClick = {  },
                                modifier = Modifier.align(Alignment.End)
                            ) {
                                Text(
                                    text = "Xem thêm (${productComments.size - 3})",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                } else {
                    Text(
                        text = "Chưa có bình luận nào",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    text = "Bình luận",
//                    style = MaterialTheme.typography.titleMedium,
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                // Lọc comments theo productId
//                val productComments = comments.filter { it.productId == productId }
//                LazyColumn(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                ) {
//                    items(productComments) { comment ->
//                        CommentCard(comment = comment)
//                    }
//                }
            } else {
                Text(text = "Không tìm thấy sản phẩm")
            }
        }
    }
}

@Composable
fun CommentCard(comment: Comment) {
    val formattedDate = SimpleDateFormat("dd/MM/yyyy").format(comment.date)
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            hoveredElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = comment.username,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = formattedDate,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}