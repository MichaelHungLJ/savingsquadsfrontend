package com.example.savingsquadsfrontend.view.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.savingsquadsfrontend.model.data.Voucher
import com.example.savingsquadsfrontend.view.components.CustomTopBar
import com.example.savingsquadsfrontend.view.components.VoucherCardRedeem
import com.example.savingsquadsfrontend.view.components.VoucherCartApply
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoucherSelectionScreen (navController: NavController) {
    val voucher = Voucher("Free Delivery", "Min spend $30", 3.99)


    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopBar(screenName = "Backstack", navController = navController, prevScreenTitle = "Cart")
        }
    ){ values ->
        LazyColumn(
            modifier = Modifier.padding(values)
        ){
            item { VoucherCartApply(voucher) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VoucherSelectionScreenPreview() {

    val fakeContext = LocalContext.current
    val fakeNavController = NavController(fakeContext)

    SavingsquadsfrontendTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VoucherSelectionScreen(fakeNavController)
        }
    }
}
