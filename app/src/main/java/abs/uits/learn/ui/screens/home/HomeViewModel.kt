package abs.uits.learn.ui.screens.home

import abs.uits.learn.domain.model.products
import abs.uits.learn.domain.network.RetrofitClient
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    suspend fun GetAllProducts(): products {
        var products = RetrofitClient.Api.getAllProducts()
        return products
    }
}