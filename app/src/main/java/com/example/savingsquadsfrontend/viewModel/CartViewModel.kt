package com.example.savingsquadsfrontend.viewModel

import androidx.lifecycle.ViewModel
import com.example.savingsquadsfrontend.model.data.CartItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {

    private var _totalSum = MutableStateFlow(0.00)
    val totalSum = _totalSum.asStateFlow()

    private var _cartList = MutableStateFlow(listOf<CartItem>(
        CartItem("Bubble Tea", 5.50, 1),
        CartItem("Honey Tea", 4.50, 2),
        CartItem("Brown Sugar" , 5.50, 3)
    ))
    val cartList = _cartList.asStateFlow()

    fun updateCartList (newCartList: List<CartItem>) {
        _cartList.value = newCartList
    }
    fun updateTotalSum (newSum : Double) {
        _totalSum.value = newSum
    }
}
