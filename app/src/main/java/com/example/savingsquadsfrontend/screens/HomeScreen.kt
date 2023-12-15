package com.example.savingsquadsfrontend.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.composable.HomeScreenHeader
import com.example.savingsquadsfrontend.composable.PointCard
import com.example.savingsquadsfrontend.composable.RestaurantCard
import com.example.savingsquadsfrontend.data.Restaurant
import com.example.savingsquadsfrontend.data.RestaurantItem
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val RestaurantList = listOf<Restaurant>(
        Restaurant("Chi Cha San Chen", R.drawable.chichasanchen),
        Restaurant("22G Coffee", R.drawable._22g)
    )

    Scaffold (
        modifier = Modifier,
        topBar = { HomeScreenHeader(logo = R.drawable.foodpanda_logo) }
    ) {values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                PointCard(navController = navController)

            }

            items(RestaurantList) { restaurant ->
                Spacer(modifier = Modifier.height(30.dp))
                RestaurantCard(navController, restaurant, true)
            }


        }

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
