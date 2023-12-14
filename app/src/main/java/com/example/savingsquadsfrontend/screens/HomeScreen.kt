package com.example.savingsquadsfrontend.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.composable.PointCard
import com.example.savingsquadsfrontend.composable.RestaurantCard
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme

@Composable
fun HomeScreen(navController: NavController) {

    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Delivery Address bar goes here")

        PointCard(navController = navController)

        RestaurantCard(navController, "Restaurant Name", R.drawable.restaurantimage, true)
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    val fakeContext = LocalContext.current
    val fakeNavController = NavController(fakeContext)

    SavingsquadsfrontendTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(fakeNavController)
        }
    }
}
