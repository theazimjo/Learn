package abs.uits.learn.ui.screens.home

import abs.uits.learn.domain.model.Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Home(modifier: Modifier = Modifier, viewModel: HomeViewModel) {

    var products by remember { mutableStateOf<List<Product>>(emptyList()) }

    LaunchedEffect(Unit) {
        var productss = viewModel.GetAllProducts().products
        products = productss
    }

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyRow() {
            items(products) { product ->
                ProductItem(modifier = Modifier, product)
            }
        }
    }
}


@Composable
fun ProductItem(modifier: Modifier = Modifier, products: Product) {
    Column(modifier
        .width(60.dp)
        .height(60.dp)) {
        Text(products.title)
        Text(products.description)

    }
}