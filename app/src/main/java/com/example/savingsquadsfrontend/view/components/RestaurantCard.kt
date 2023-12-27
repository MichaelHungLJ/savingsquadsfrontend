package com.example.savingsquadsfrontend.view.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.view.theme.Typography
import com.example.savingsquadsfrontend.viewModel.Restaurant
import com.example.savingsquadsfrontend.viewModel.RestaurantItem


@Composable
fun RestaurantCard (navController: NavController, index:Int, restaurant: Restaurant, clickable: Boolean) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.5.dp
        ),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .clickable(
                enabled = clickable
            ) { navController.navigate("RestaurantScreen/$index") },
    ){
        Column (
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
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
                text = restaurant.name,
                style = Typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}


@Preview
@Composable
fun RestaurantCardPreview() {
    val fakeNavController = rememberNavController() // Create a fake NavController for preview

    val Coffee22GMenu = listOf<RestaurantItem>(
        RestaurantItem("Americano", 5.50,R.drawable.americano,"Long black"),
        RestaurantItem("Earl grey tea", 4.50,R.drawable.earlgreytea,"Earl Grey Tea"),
        RestaurantItem("Expresso", 6.00,R.drawable.expresso,"Expresso"),
        RestaurantItem("Iced Latte", 7.50,R.drawable.icedlatte,"Iced Latte"),
        RestaurantItem("Matcha Latte", 8.00,R.drawable.matchalatte,"Matcha Latte")
    )

    val restaurant1 = Restaurant("22G Coffee", R.drawable._22g, Coffee22GMenu )
    val index = 0;

    SavingsquadsfrontendTheme {
        RestaurantCard(navController = fakeNavController, 0, restaurant1, clickable = true)
    }
}
