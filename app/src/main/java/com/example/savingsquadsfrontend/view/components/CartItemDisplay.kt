package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savingsquadsfrontend.model.data.CartItem

@Composable
fun CartItemDisplay (
    cartItem: CartItem
) {

    var amount by remember { mutableDoubleStateOf(cartItem.price * cartItem.quantity) }
    var count by remember { mutableIntStateOf(cartItem.quantity) }

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
            modifier = Modifier.padding(start = 5.dp)
        )

        Text(
            text = "$"+ String.format("%.2f", amount),
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 30.dp)
        )
        CartCounter(
            quantityState = count,
            onQuantityChange = {
                newCount ->
                count = newCount
                amount = cartItem.price * newCount
            })
    }
}

@Preview (showBackground = true)
@Composable
fun CartItemDisplayPreview() {

    val cartItem1 = CartItem("Bubble Tea", 5.50, 1)
    CartItemDisplay(cartItem1)
}
