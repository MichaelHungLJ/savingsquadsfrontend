package com.example.savingsquadsfrontend.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme

@Composable
fun HomeScreen(navController: NavController) {

    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Delivery Address bar goes here")
        Text(text = "Point tracker card goes here")

        RestaurantCard(navController, "Restaurant Name", R.drawable.restaurantimage)
    }
}

@Composable
fun RestaurantCard (navController: NavController, resTitle: String, resImage: Int) {
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .clickable { navController.navigate("RestaurantScreen") }
        ,
    ){
        Column (
            modifier = Modifier,

        ) {
            Image(
                painter = painterResource(id = resImage),
                contentDescription = "Restuarant Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                modifier = Modifier.padding(start = 14.dp, top = 6.dp),
                fontSize = 12.sp,
                text = resTitle
            )
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
