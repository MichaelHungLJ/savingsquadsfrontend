package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.viewModel.RestaurantItem

@Composable
fun RestaurantItemCard(restaurantItem: RestaurantItem) {

    Card (
        modifier = Modifier
            .width(300.dp)
            .height(80.dp),
    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = restaurantItem.image),
                contentDescription = restaurantItem.desc)

            Column (
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight()
                    .padding(start = 4.dp, 8.dp)
            ){
                Text(
                    text = restaurantItem.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp)
                Text(
                    text = "$"+ String.format("%.2f", restaurantItem.price),
                    modifier = Modifier.padding(top=4.dp))
            }

            FoodCounter()
        }
    }
}

@Composable
fun FoodCounter(){
    // Hardcoded value
    var count by remember { mutableStateOf(0) }

    Row (
        modifier = Modifier
            .width(60.dp)
            .height(25.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            onClick = { if (count > 0) count-- },
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Gray),
        ) {
            Icon(painter = painterResource(id = R.drawable.remove), contentDescription = "remove")
        }

        Text(
            text = "$count",
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { count++ },
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Gray),
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantItemCardPreview(){

    val item = RestaurantItem("Tea with Honey", 6.00, R.drawable.teawithhoney, "Cheapest tea paired with fake honey")

    RestaurantItemCard(restaurantItem = item)
}