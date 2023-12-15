package com.example.savingsquadsfrontend.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.data.Restaurant
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme


@Composable
fun RestaurantCard (navController: NavController, restaurant: Restaurant, clickable: Boolean) {
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .clickable(
                enabled = clickable
            ) { navController.navigate("RestaurantScreen") }
        ,
    ){
        Column (
            modifier = Modifier,
            ) {
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = "Restuarant Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                modifier = Modifier.padding(start = 10.dp, top = 8.dp),
                fontSize = 12.sp,
                text = restaurant.name
            )
        }
    }
}


@Preview
@Composable
fun RestaurantCardPreview() {
    val fakeNavController = rememberNavController() // Create a fake NavController for preview

    val restaurant1 = Restaurant("22G Coffee", R.drawable._22g)

    SavingsquadsfrontendTheme {
        RestaurantCard(navController = fakeNavController, restaurant1, clickable = true)
    }
}
