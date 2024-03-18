package com.example.savingsquadsfrontend.view.screens


import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.view.components.HomeScreenHeader
import com.example.savingsquadsfrontend.view.components.PointCard
import com.example.savingsquadsfrontend.view.components.RestaurantCard
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.viewModel.RestaurantViewModel
import com.example.savingsquadsfrontend.viewModel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    restaurantViewModel: RestaurantViewModel,

) {
    val restaurants = restaurantViewModel.restaurants

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

            itemsIndexed(restaurants.value) {
                index,restaurant ->
                Spacer(modifier = Modifier.height(30.dp))
                RestaurantCard(navController, index ,restaurant, true)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    val restaurantViewModel = RestaurantViewModel()
//    val fakeContext = LocalContext.current
//    val fakeNavController = NavController(fakeContext)
//
//    SavingsquadsfrontendTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            HomeScreen(fakeNavController,restaurantViewModel)
//        }
//    }
//}
