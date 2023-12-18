package com.example.savingsquadsfrontend.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.view.components.CartItemDisplay
import com.example.savingsquadsfrontend.view.components.CustomTopBar
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.viewModel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen (navController: NavController, cartViewModel: CartViewModel) {

    val cartList by cartViewModel.cartList.collectAsState()

    Scaffold (
        modifier = Modifier,
        topBar = {
            CustomTopBar(screenName = "Backstack", navController = navController, prevScreenTitle = "Restaurant")
        }
    ){values ->
        LazyColumn(
            modifier = Modifier.padding(values),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            
            item {
                Column (
                    modifier = Modifier.background(Color.Gray)
                ){
                    cartList.forEach { item ->
                        CartItemDisplay(cartItem = item)
                    }
                }
            }

            item {
                Column (
                    modifier = Modifier.background(Color.Gray)
                ){

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

    SavingsquadsfrontendTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CartScreen(fakeNavController, cartViewModel)
        }
    }
}
