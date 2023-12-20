package com.example.savingsquadsfrontend.view.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.model.data.CartItem
import com.example.savingsquadsfrontend.view.components.CartCostBar
import com.example.savingsquadsfrontend.view.components.CartItemDisplay
import com.example.savingsquadsfrontend.view.components.CustomBottomBar
import com.example.savingsquadsfrontend.view.components.CustomTopBar
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.viewModel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen (navController: NavController, cartViewModel: CartViewModel) {

    val cartList by cartViewModel.cartList.collectAsState()
    val totalCost by cartViewModel.totalSum.collectAsState()

    Log.d("Cart Screen", "Initial Cart List: ${cartViewModel.cartList.collectAsState()}" )


    Scaffold (
        modifier = Modifier,
        topBar = {
            CustomTopBar(screenName = "Backstack", navController = navController, prevScreenTitle = "Restaurant")
        },
        bottomBar = {
            CustomBottomBar(navController = navController, nextPage = "Payment", buttonName = "Payment")
        }
    ){values ->
        LazyColumn(
            modifier = Modifier.padding(values),
        ) {
            
            item {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(start = 40.dp, top = 20.dp, end = 40.dp)
                        .background(Color.Gray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    cartList.forEach { item ->
                        CartItemDisplay(cartItem = item,cartViewModel = cartViewModel)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(5.dp))
            }

            item {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(330.dp)
                        .padding(start = 40.dp, top = 20.dp, end = 40.dp)
                        .background(Color.Gray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    CartCostBar(name = "Sub total", cost = totalCost)

                    CartCostBar(name = "Delivery Fee", cost = 3.99)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {

    val fakeContext = LocalContext.current
    val fakeNavController = NavController(fakeContext)
    val cartViewModel = CartViewModel()

    val item1 = CartItem("Tea with Honey", 6.00, 2)
    val item2 = CartItem("Tea with Mango", 7.50, 1)
    val item3 = CartItem("Bubble Tea", 5.50, 3)

    cartViewModel.addToCart(item1)
    cartViewModel.addToCart(item2)
    cartViewModel.addToCart(item3)
    cartViewModel.updateTotalSum()

    SavingsquadsfrontendTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CartScreen(fakeNavController, cartViewModel)
        }
    }
}
