package com.example.savingsquadsfrontend.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.view.components.CustomTopBar
import com.example.savingsquadsfrontend.view.components.VoucherCardRedeem
import com.example.savingsquadsfrontend.model.data.VoucherRedeem
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoucherRedemptionScreen (navController: NavController) {

    // Hardcoded - Change later
    val voucherList = listOf<VoucherRedeem>(
        VoucherRedeem("$5 Off", "100 Points"),
        VoucherRedeem("$10 Off", "200 Points"),
        VoucherRedeem("$20 Off", "400 points"),
        VoucherRedeem("$5 Off", "100 Points"),
        VoucherRedeem("$10 Off", "200 Points"),
        VoucherRedeem("$20 Off", "400 points"),
        VoucherRedeem("$5 Off", "100 Points"),
        VoucherRedeem("$10 Off", "200 Points"),
        VoucherRedeem("$20 Off", "400 points"),
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopBar(screenName = "HomeScreen", navController = navController, prevScreenTitle = "Home")
        },
    ) {
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
                PointDisplayCard()
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }


        items(voucherList) {
               voucher ->
               VoucherCardRedeem(voucher)
           }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun VoucherRedemptionScreenPreview() {

    val fakeContext = LocalContext.current
    val fakeNavController = NavController(fakeContext)

    SavingsquadsfrontendTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VoucherRedemptionScreen(fakeNavController)
        }
    }
}


@Composable
fun PointDisplayCard() {
    Card (
        modifier = Modifier
            .width(300.dp)
            .height(66.dp),
        ){

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "800 Points",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

