package com.example.savingsquadsfrontend.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme

@Composable
fun PointCard (navController: NavController) {
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp),


        ){
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            PointHeader(navController)
        }
    }
}
@Composable
fun PointHeader(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Points: 800",
            modifier = Modifier
                .size(width = 260.dp, height = 46.dp)
                .padding(top = 5.dp, start = 5.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )

        Button(
            modifier = Modifier
                .size(width = 100.dp, height = 20.dp)
                .align(Alignment.End)
                .padding(end = 10.dp),
            onClick = { navController.navigate("VoucherRedemptionScreen")
            }
        ) {
            Text(
                text = "Redeem",
                fontSize = 6.sp)
        }

        Text(
            text = "Lifetime saved: $50.00",
            fontSize = 8.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(5.dp)
        )

        PointProgress()


    }
}
@Preview(showBackground = true)
@Composable
fun PointProgress(){
    Column (
        modifier = Modifier.size(width = 270.dp, height = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp),
            progress = 0.5f // Set your progress value here (between 0.0 and 1.0)
        )

    }
}

@Preview
@Composable
fun PointHeaderPreview() {
    val fakeNavController = rememberNavController() // Create a fake NavController for preview
    SavingsquadsfrontendTheme {
        PointCard(navController = fakeNavController)
    }
}
