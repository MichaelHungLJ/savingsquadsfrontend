package com.example.savingsquadsfrontend.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.savingsquadsfrontend.api.LoginRequest
import com.example.savingsquadsfrontend.view.screens.CartScreen
import com.example.savingsquadsfrontend.view.screens.HomeScreen
import com.example.savingsquadsfrontend.view.screens.RestaurantScreen
import com.example.savingsquadsfrontend.view.screens.VoucherRedemptionScreen
import com.example.savingsquadsfrontend.view.screens.VoucherSelectionScreen
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.viewModel.CartViewModel
import com.example.savingsquadsfrontend.viewModel.RestaurantViewModel
import com.example.savingsquadsfrontend.viewModel.UserViewModel
import com.example.savingsquadsfrontend.viewModel.VoucherRedemptionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val userViewModel by viewModels<UserViewModel>()
    private val restaurantViewModel by viewModels<RestaurantViewModel>()
    private val voucherRedemptionViewModel by viewModels<VoucherRedemptionViewModel>()
    private val cartViewModel by viewModels<CartViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val testAccount = LoginRequest("michael@example.com", "michaeltest") // hardcoded data to login
        userViewModel.loginUser(testAccount)

        setContent {
            SavingsquadsfrontendTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    VoucherApp(
                        restaurantViewModel = restaurantViewModel,
                        voucherRedemptionViewModel = voucherRedemptionViewModel,
                        cartViewModel = cartViewModel,
                        userViewModel = userViewModel
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            userViewModel.logoutUser()
        }
    }
}

@Composable
fun VoucherApp(
    restaurantViewModel: RestaurantViewModel,
    voucherRedemptionViewModel: VoucherRedemptionViewModel,
    cartViewModel: CartViewModel,
    userViewModel: UserViewModel
) {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "HomeScreen") {

        composable("HomeScreen") {
            HomeScreen(navController = navController, restaurantViewModel = restaurantViewModel)
        }

        composable(
            route = "RestaurantScreen/{restaurantIndex}",
            arguments = listOf(navArgument("restaurantIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments!!.getInt("restaurantIndex")
            RestaurantScreen(
                navController = navController,
                restaurantViewModel = restaurantViewModel,
                restaurantIndex = index,
                cartViewModel = cartViewModel)
        }

        composable("CartScreen") {
            CartScreen(navController = navController, cartViewModel = cartViewModel)
        }

        composable("VoucherRedemptionScreen") {
            VoucherRedemptionScreen(navController = navController, voucherRedemptionViewModel = voucherRedemptionViewModel )
        }

        composable("VoucherSelectionScreen") {
            VoucherSelectionScreen(navController = navController)
        }


    }


}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//
//    val restaurantViewModel = RestaurantViewModel()
//    val voucherRedemptionViewModel = VoucherRedemptionViewModel()
//    val cartViewModel = CartViewModel()
//
//
//    SavingsquadsfrontendTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            VoucherApp(
//                restaurantViewModel = restaurantViewModel,
//                voucherRedemptionViewModel = voucherRedemptionViewModel,
//                cartViewModel = cartViewModel,
//            )
//        }
//    }
//}

