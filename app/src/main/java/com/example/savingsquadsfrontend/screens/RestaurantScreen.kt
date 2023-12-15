package com.example.savingsquadsfrontend.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.composable.CustomBottomBar
import com.example.savingsquadsfrontend.composable.CustomTopBar
import com.example.savingsquadsfrontend.composable.RestaurantCard
import com.example.savingsquadsfrontend.composable.RestaurantItemCard
import com.example.savingsquadsfrontend.composable.VoucherCardRedeem
import com.example.savingsquadsfrontend.data.Restaurant
import com.example.savingsquadsfrontend.data.RestaurantItem
import com.example.savingsquadsfrontend.data.VoucherRedeem
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController) {

    val restaurant = Restaurant("Chi Cha San Chen", R.drawable.chichasanchen)


    val RestaurantItemList = listOf<RestaurantItem>(
        RestaurantItem("Tea with Honey", 6.00, R.drawable.teawithhoney, "Cheapest tea paired with fake honey"),
        RestaurantItem("Tea with Mango", 7.50, R.drawable.teawithmango, "Cheapest tea paired with fake honey"),
        RestaurantItem("Bubble Tea", 5.50, R.drawable.bubblemilktea, "Cheapest tea paired with fake honey"),
        RestaurantItem("Brown Sugar Tea", 8.50, R.drawable.brownsugarbubbletea, "Cheapest tea paired with fake honey"),
    )

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
                RestaurantCard(navController, restaurant, false)
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }

            items(RestaurantItemList) {
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

    SavingsquadsfrontendTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RestaurantScreen(fakeNavController)
        }
    }
}
