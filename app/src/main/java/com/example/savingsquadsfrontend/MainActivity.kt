package com.example.savingsquadsfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.screens.CartScreen
import com.example.savingsquadsfrontend.screens.HomeScreen
import com.example.savingsquadsfrontend.screens.RestaurantScreen
import com.example.savingsquadsfrontend.screens.VoucherRedemptionScreen
import com.example.savingsquadsfrontend.screens.VoucherSelectionScreen
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SavingsquadsfrontendTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VoucherApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SavingsquadsfrontendTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VoucherApp()
        }
    }
}

@Composable
fun VoucherApp() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "HomeScreen") {

        composable("HomeScreen") {
            HomeScreen(navController = navController)
        }

        composable("RestaurantScreen") {
            RestaurantScreen(navController = navController)
        }

        composable("CartScreen") {
            CartScreen(navController = navController)
        }

        composable("VoucherRedemptionScreen") {
            VoucherRedemptionScreen(navController = navController)
        }

        composable("VoucherSelectionScreen") {
            VoucherSelectionScreen(navController = navController)
        }


    }


}


