package com.example.savingsquadsfrontend.view.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.view.components.CustomBottomBar
import com.example.savingsquadsfrontend.view.components.CustomTopBar
import com.example.savingsquadsfrontend.view.components.RestaurantCard
import com.example.savingsquadsfrontend.view.components.RestaurantItemCard
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.viewModel.RestaurantViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(
    navController: NavController,
    restaurantViewModel: RestaurantViewModel,
    restaurantIndex:Int,
) {

    val restaurant = restaurantViewModel.restaurants.value[restaurantIndex]

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopBar(screenName = "HomeScreen", navController = navController, prevScreenTitle = "Home")
        },
        bottomBar = {
            CustomBottomBar(navController = navController, nextPage = "CartScreen", buttonName = "Checkout")
        }
    ){
        values -> LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            item {
                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                RestaurantCard(navController,restaurantIndex, restaurant, false)
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }

            items(restaurant.menu) {
                    item ->
                Spacer(modifier = Modifier.height(20.dp))
                RestaurantItemCard(item)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun RestaurantScreenPreview() {

    val fakeContext = LocalContext.current
    val fakeNavController = NavController(fakeContext)
    val restaurantViewModel = RestaurantViewModel()
    val index = 0 // First restaurant

    SavingsquadsfrontendTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RestaurantScreen(fakeNavController, restaurantViewModel, index)
        }
    }
}
