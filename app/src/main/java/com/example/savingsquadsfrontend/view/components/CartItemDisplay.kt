package com.example.savingsquadsfrontend.view.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savingsquadsfrontend.model.data.CartItem
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.viewModel.CartViewModel

@Composable
fun CartItemDisplay (
    cartItem: CartItem,
    cartViewModel: CartViewModel
) {
    var amount by remember { mutableDoubleStateOf(cartItem.price * cartItem.quantity) }
    var count by remember { mutableIntStateOf(cartItem.quantity) }

    val cartList by cartViewModel.cartList.collectAsState()


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = cartItem.name,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 4.dp)
                .width(160.dp),
            color = MaterialTheme.colorScheme.onSurface
        )


        Text(
            text = "$"+ String.format("%.2f", amount),
            fontSize = 16.sp,
            modifier = Modifier.width(60.dp),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start
        )


        CartCounter(
            quantityState = count,
            onQuantityChange = {
                newCount ->
                count = newCount
                amount = cartItem.price * newCount
                if (newCount != 0) cartViewModel.addToCart(CartItem(cartItem.name,cartItem.price,count))
                else cartViewModel.removeFromCart(CartItem(cartItem.name,cartItem.price,count))
                Log.d("CartItemDisplay", "${cartItem.name} added to cart with count: $count")
                Log.d("CartItemDisplay", "Here's the updated cartList: $cartList")
            })
    }
}

@Preview (showBackground = true)
@Composable
fun CartItemDisplayPreview() {

    val cartViewModel = CartViewModel()

    val cartItem1 = CartItem("Bubble Tea", 5.50, 1)
    SavingsquadsfrontendTheme {
        CartItemDisplay(cartItem1,cartViewModel)
    }
}


@Preview (showBackground = true)
@Composable
fun CartItemDisplayPreview2() {

    val cartViewModel = CartViewModel()

    val cartItem1 = CartItem("Bubble Tea", 15.50, 1)
    SavingsquadsfrontendTheme {
        CartItemDisplay(cartItem1,cartViewModel)
    }
}
