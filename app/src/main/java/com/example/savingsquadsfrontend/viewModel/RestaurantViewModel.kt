package com.example.savingsquadsfrontend.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.savingsquadsfrontend.R

class RestaurantViewModel : ViewModel() {

    private val ChiChaSanChenMenu = listOf<RestaurantItem>(
        RestaurantItem("Tea with Honey", 6.00, R.drawable.teawithhoney, "Cheap tea"),
        RestaurantItem("Tea with Mango", 7.50, R.drawable.teawithmango,"Expensive tea"),
        RestaurantItem("Bubble Tea", 5.50, R.drawable.bubblemilktea, "Milk Tea"),
        RestaurantItem("Brown sugar Tea", 8.50, R.drawable.brownsugarbubbletea,"Brown Sugar Tea")
    )

    private val Coffee22GMenu = listOf<RestaurantItem>(
        RestaurantItem("Americano", 5.50,R.drawable.americano,"Long black"),
        RestaurantItem("Earl grey tea", 4.50,R.drawable.earlgreytea,"Earl Grey Tea"),
        RestaurantItem("Expresso", 6.00,R.drawable.expresso,"Expresso"),
        RestaurantItem("Iced Latte", 7.50,R.drawable.icedlatte,"Iced Latte"),
        RestaurantItem("Matcha Latte", 8.00,R.drawable.matchalatte,"Matcha Latte")
    )

    private val _restaurants = mutableStateOf<List<Restaurant>>(
        listOf(
            Restaurant("Chi Cha San Chen", R.drawable.chichasanchen, ChiChaSanChenMenu),
            Restaurant("22G Coffee", R.drawable._22g,Coffee22GMenu)
            )
    )

    val restaurants: MutableState<List<Restaurant>> = _restaurants

}

data class Restaurant (
    val name: String,
    val image: Int,
    val menu: List<RestaurantItem>
)

data class RestaurantItem (
    val name: String,
    val price: Double,
    val image: Int,
    val desc: String,
)
