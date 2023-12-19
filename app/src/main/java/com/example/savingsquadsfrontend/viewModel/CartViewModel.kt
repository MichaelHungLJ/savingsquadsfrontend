package com.example.savingsquadsfrontend.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.savingsquadsfrontend.model.data.CartItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {

    private var _totalSum = MutableStateFlow(0.00)
    val totalSum = _totalSum.asStateFlow()

    private var _cartList = MutableStateFlow(
        mutableListOf<CartItem>()
    )
    val cartList = _cartList.asStateFlow()

    fun addToCart(cartItem: CartItem) {
        val currentList = _cartList.value

        val existingItem = currentList.find { it.name == cartItem.name }

        if (existingItem != null) {
            existingItem.quantity = cartItem.quantity
        }
        else {
            currentList.add(cartItem)
        }

        _cartList.tryEmit(currentList)

        Log.d("CartUpdate", "Item added to cart: $cartItem")
    }

    fun updateTotalSum (newSum : Double) {
        _totalSum.value = newSum
    }


}
